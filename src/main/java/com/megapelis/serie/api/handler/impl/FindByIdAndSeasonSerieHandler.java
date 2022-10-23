package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.model.dto.request.FindByIdAndSeasonSerieRQ;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link FindByIdAndSeasonSerieHandler}
 * @author sergio.barrios.
 */
public class FindByIdAndSeasonSerieHandler extends SerieHandler{

    /**
     * Metodo que permite validar el payload.
     * @param request
     * @return {@link Object}
     * @throws SerieException
     */
    @Override
    public Object validatePayload(Request request) throws SerieException {
        FindByIdAndSeasonSerieRQ findByIdAndSeasonSerieRQ = convertPayload(request, FindByIdAndSeasonSerieRQ.class);
        if(!SerieCommon.isValidString(findByIdAndSeasonSerieRQ.getIdSerie(), findByIdAndSeasonSerieRQ.getSeason()))
            throw new SerieException(SerieStatusEnum.ERROR_FORMAT_REQUEST);
        return findByIdAndSeasonSerieRQ;
    }

    /**
     * Metodo que permite construir la url del servicio.
     * @param object
     * @return {@link String}
     * @throws SerieException
     */
    @Override
    public String url(Object object) throws SerieException {
        FindByIdAndSeasonSerieRQ findByIdAndSeasonSerieRQ = (FindByIdAndSeasonSerieRQ) object;
        tmdbUrl.setOperation(SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON_NAME));
        SerieCommon.addProperties(tmdbUrl, tmdbUrl.getHost(), findByIdAndSeasonSerieRQ.getIdSerie(), findByIdAndSeasonSerieRQ.getSeason(), tmdbUrl.getKey());
        return buildUrl(tmdbUrl);
    }
}
