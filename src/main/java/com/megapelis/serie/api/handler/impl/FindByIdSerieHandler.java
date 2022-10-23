package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.model.dto.request.FindByIdSerieRQ;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link FindByIdSerieHandler}
 * @author sergio.barrios.
 */
public class FindByIdSerieHandler extends SerieHandler {

    /**
     * Metodo que permite validar el payload.
     * @param request
     * @return {@link Object}
     * @throws SerieException
     */
    @Override
    public Object validatePayload(Request request) throws SerieException{
        FindByIdSerieRQ findAllByIdSerieRQ = convertPayload(request, FindByIdSerieRQ.class);
        if(!SerieCommon.isValidString(findAllByIdSerieRQ.getIdSerie()))
            throw new SerieException(SerieStatusEnum.ERROR_FORMAT_REQUEST);
        return findAllByIdSerieRQ;
    }

    /**
     * Metodo que permite construir la url del servicio.
     * @param object
     * @return {@link String}
     * @throws SerieException
     */
    @Override
    public String url(Object object) throws SerieException {
        FindByIdSerieRQ findAllByIdSerieRQ = (FindByIdSerieRQ) object;
        tmdbUrl.setOperation(SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_NAME));
        SerieCommon.addProperties(tmdbUrl, tmdbUrl.getHost(), findAllByIdSerieRQ.getIdSerie(),  tmdbUrl.getKey());
        return buildUrl(tmdbUrl);
    }
}
