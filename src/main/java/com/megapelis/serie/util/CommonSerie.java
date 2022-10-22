package com.megapelis.serie.util;

import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.model.dto.response.generic.Response;
import com.megapelis.serie.model.dto.response.generic.ResponseStatus;
import com.megapelis.serie.util.enums.StatusEnum;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class CommonSerie {

    public static boolean isValidString(String value){
        return null != value && !value.trim().isEmpty();
    }

    public static boolean isValidString(String ... values){
        for (String value : values){
            if(!isValidString(value)){
                return ConstantSerie.BOOLEAN_FALSE;
            }
        }
        return ConstantSerie.BOOLEAN_TRUE;
    }

    public static String dateTime(){
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh.mm.ss a"));
    }

    /**
     *
     * @param properties
     * @param name
     * @return
     */
    public static RequestProperty findByNameProperty(List<RequestProperty> properties, String name, boolean isDefault){
        RequestProperty propertyDefault = null;
        if(isDefault)
            propertyDefault = new RequestProperty(ConstantSerie.STRING_PROPERTY_DEFAULT_NAME, ConstantSerie.STRING_PROPERTY_DEFAULT_VALUE);
        if(null == properties || null == name)
            return propertyDefault;
        return properties.stream()
                .filter(property -> property.getName().equals(name))
                .findFirst()
                .orElse(propertyDefault);
    }

    /**
     *
     * @param request
     * @return
     */
    public static Response buildResponse(Request request){
        return buildResponse(request, null, null, null);
    }

    /**
     *
     * @param request
     * @param statusEnum
     * @return
     */
    public static Response buildResponse(Request request, StatusEnum statusEnum){
        return buildResponse(request, statusEnum, null);
    }

    /**
     *
     * @param request
     * @param statusEnum
     * @param data
     * @return
     */
    public static Response buildResponse(Request request, StatusEnum statusEnum, Object data){
        return buildResponse(request, statusEnum.getCode(), statusEnum.getMessage(), data);
    }

    /**
     *
     * @param request
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static Response buildResponse(Request request, String code, String message, Object data){
        if(null == request)
            return null;
        if(!isValidString(code,message)){
            code = StatusEnum.ERROR.getCode();
            message = StatusEnum.ERROR.getMessage();
        }
        String dateTime = CommonSerie.dateTime();
        return Response
                .builder()
                .traceId(request.getTraceId())
                .dateTime(dateTime)
                .service(request.getService())
                .operation(request.getOperation())
                .status(new ResponseStatus(code, message))
                .data(data)
                .build();
    }
}
