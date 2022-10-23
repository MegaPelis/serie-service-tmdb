package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.model.dto.request.FindAllByPopularSerieRQ;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link FindAllByPopularSerieHandler}
 * @author sergio.barrios.
 */
public class FindAllByPopularSerieHandler extends SerieHandler {

    /**
     * Metodo que permite validar el payload.
     * @param request
     * @return {@link Object}
     * @throws SerieException
     */
    @Override
    public Object validatePayload(Request request) throws SerieException {
        FindAllByPopularSerieRQ findAllByPopularSerieRQ = convertPayload(request, FindAllByPopularSerieRQ.class);
        if(SerieConstant.INTEGER_ONE > findAllByPopularSerieRQ.getPage())
            findAllByPopularSerieRQ.setPage(SerieConstant.INTEGER_ONE);
        return findAllByPopularSerieRQ;
    }

    /**
     * Metodo que permite construir la url del servicio.
     * @param object
     * @return {@link String}
     * @throws SerieException
     */
    @Override
    public String url(Object object) throws SerieException {
        FindAllByPopularSerieRQ findAllByPopularSerieRQ = (FindAllByPopularSerieRQ) object;
        tmdbUrl.setOperation(SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_POPULAR));
        SerieCommon.addProperties(tmdbUrl, tmdbUrl.getHost(), tmdbUrl.getKey(), String.valueOf(findAllByPopularSerieRQ.getPage()));
        return buildUrl(tmdbUrl);
    }
}
