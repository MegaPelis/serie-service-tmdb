package com.megapelis.serie.api.handler;

import com.google.gson.JsonObject;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.response.Response;
import com.megapelis.serie.model.entity.TMDB;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link SerieHandler}
 * @author sergio.barrios.
 */
public abstract class SerieHandler extends SerieGenericCommon {

    /**
     * Metodo que permite ejecutar la logica del handler.
     * @param request
     * @return {@link Response}
     */
    public Response execute(Request request){
        Response response;
        try {
            Object object = validatePayload(request);
            this.tmdbUrl = buildTMBDUrl();
            String url = url(object);
            TMDB tmdb = tmdb(url);
            JsonObject jsonObject = this.tmdb.execute(tmdb);
            response = SerieCommon.buildResponse(request, SerieStatusEnum.SUCCESS, jsonObject);
        } catch (SerieException exception) {
            response = SerieCommon.buildResponse(request, exception.getStatus());
        }
        return response;
    }

    /**
     * Metodo que permite validar el payload.
     * @param request
     * @return {@link Object}
     * @throws SerieException
     */
    public abstract Object validatePayload(Request request) throws SerieException;

    /**
     * Metodo que permite construir la url del servicio.
     * @param object
     * @return {@link String}
     * @throws SerieException
     */
    public abstract String url(Object object) throws SerieException;
}
