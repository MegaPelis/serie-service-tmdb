package com.megapelis.serie.util;

import com.google.gson.Gson;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.api.model.dto.response.generic.Response;
import com.megapelis.serie.api.model.dto.response.generic.ResponseStatus;
import com.megapelis.serie.api.model.entity.TMDB;
import com.megapelis.serie.api.model.enums.StatusEnum;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Clase {@link CommonSerie}
 * @author sergio.barrios.
 */
public class CommonSerie {

    private CommonSerie(){}

    /**
     * Metodo que permite validar una cadena no este vacia.
     * @param value
     * @return {@link boolean}
     */
    public static boolean isValidString(String value){
        return null != value && !value.trim().isEmpty();
    }

    /**
     * Metodo que permite validar varias cadenas.
     * @param values
     * @return {@link boolean}
     */
    public static boolean isValidString(String ... values) {
        for (String value : values) {
            if (!isValidString(value)) {
                return ConstantSerie.BOOLEAN_FALSE;
            }
        }
        return ConstantSerie.BOOLEAN_TRUE;
    }

    /**
     * Metodo que valida la petición.
     * @param request
     * @throws SerieException
     */
    public static void isValidRequest(Request request) throws SerieException{
        if(null == request || !isValidString(request.getTraceId(), request.getDateTime(), request.getService(), request.getOperation()))
            throw new SerieException(StatusEnum.ERROR_FORMAT_REQUEST);
    }

    /**
     * Metodo que permite obtener la fecha y hora actual.
     * @return {@link String}
     */
    public static String getDateTime(){
        return ZonedDateTime.now(ZoneId.of(ConstantSerie.STRING_DATE_ZONE))
                .format(DateTimeFormatter.ofPattern(ConstantSerie.STRING_DATE_TIME_FORMAT));
    }

    /**
     * Metodo que permite obtener el valor de una variable de entorno.
     * @param name
     * @return {@link String}
     * @throws SerieException
     */
    public static String getEnv(String name) throws SerieException {
        if(!isValidString(name))
            throw new SerieException(StatusEnum.ERROR_ENV);
        String env = System.getenv(name);
        if(!isValidString(env)){
            throw new SerieException(StatusEnum.ERROR_ENV_NOT_CONTENT);
        }
        return env;
    }

    /**
     * Metodo que permite obtener el objeto en cadena.
     * @param object
     * @return {@link  String}
     */
    public static String getStringJSON(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * Metodo que convierte un objeto a clase.
     * @param object
     * @param clazz
     * @return {@link T}
     * @param <T>
     */
    public static <T> T convertObjectToClass(Object object, Class<T> clazz){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return gson.fromJson(json, clazz);
    }

    /**
     * Metodo que permite darle formato a una cadena
     * @param value
     * @param values
     * @return {@link String}
     */
    public static String formatString(String value, String ... values){
        return String.format(value, values);
    }

    /**
     * Metodo que permite buscar una propiedad por el nombre.
     * @param properties
     * @param name
     * @return {@link RequestProperty}
     */
    public static RequestProperty findByNameProperty(List<RequestProperty> properties, String name, boolean isDefault){
        RequestProperty propertyDefault = null;
        if(isDefault)
            propertyDefault = new RequestProperty(ConstantSerie.STRING_PROPERTY_DEFAULT_NAME, ConstantSerie.STRING_PROPERTY_DEFAULT_VALUE);
        if(null == properties || null == name)
            return propertyDefault;
        return properties.stream()
                .filter(property -> property.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(propertyDefault);
    }

    /**
     * Metodo que permite registrar la salida para cloud watch.
     * @param object
     */
    public static void output(Object object){
        if(object instanceof Response || object instanceof Request || object instanceof TMDB)
            System.out.println(getStringJSON(object));
        else
            System.out.println(object);
    }

    /**
     * Metodo que permite construir la respuesta del servicio.
     * @param request
     * @return {@link Response}
     */
    public static Response buildResponse(Request request){
        return buildResponse(request, null, null, null, null);
    }

    /**
     * Metodo que permite construir la respuesta del servicio.
     * @param request
     * @param statusEnum
     * @return {@link Response}
     */
    public static Response buildResponse(Request request, StatusEnum statusEnum){
        return buildResponse(request, statusEnum, null);
    }

    /**
     * Metodo que permite construir la respuesta del servicio.
     * @param request
     * @param statusEnum
     * @param data
     * @return {@link Response}
     */
    public static Response buildResponse(Request request, StatusEnum statusEnum, Object data){
        return buildResponse(request, statusEnum.getCode(), statusEnum.getMessageBackend(), statusEnum.getMessageFrontend(), data);
    }

    /**
     * Metodo que permite construir la respuesta del servicio.
     * @param request
     * @param code
     * @param messageBackend
     * @param messageFrontend
     * @param data
     * @return {@link Response}
     */
    private static Response buildResponse(Request request, String code, String messageBackend, String messageFrontend, Object data){
        if(null == request)
            return null;
        if(!isValidString(code,messageBackend, messageFrontend)){
            code = StatusEnum.ERROR.getCode();
            messageBackend = StatusEnum.ERROR.getMessageBackend();
            messageFrontend = StatusEnum.ERROR.getMessageFrontend();
        }
        String dateTime = CommonSerie.getDateTime();
        return Response
                .builder()
                .traceId(request.getTraceId())
                .dateTime(dateTime)
                .service(request.getService())
                .operation(request.getOperation())
                .status(new ResponseStatus(code, messageBackend, messageFrontend))
                .data(data)
                .build();
    }
}
