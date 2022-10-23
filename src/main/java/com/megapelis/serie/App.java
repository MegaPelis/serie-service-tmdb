package com.megapelis.serie;

import com.megapelis.serie.api.factory.SerieFactory;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.response.Response;

/**
 * Clase {@link App}
 * @author sergio.barrios.
 */
public class App{

    /**
     * Metodo que permite realizar el llamado de los servicios.
     * @param request
     * @return {@link Response}
     */
    public Response handler(Request request){
        return SerieFactory.handler(request);
    }
}
