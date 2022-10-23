package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.model.dto.request.FindByIdAndSeasonAndEpisodeSerieRQ;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link FindByIdSeasonAndEpisodeSerieHandler}
 * @author sergio.barrios.
 */
public class FindByIdSeasonAndEpisodeSerieHandler extends SerieHandler {

    /**
     * Metodo que permite validar el payload.
     * @param request
     * @return {@link Object}
     * @throws SerieException
     */
    @Override
    public Object validatePayload(Request request) throws SerieException {
        FindByIdAndSeasonAndEpisodeSerieRQ findByIdAndSeasonAndEpisodeSerieRQ = convertPayload(request, FindByIdAndSeasonAndEpisodeSerieRQ.class);
        if(!SerieCommon.isValidString(findByIdAndSeasonAndEpisodeSerieRQ.getIdSerie(), findByIdAndSeasonAndEpisodeSerieRQ.getSeason(), findByIdAndSeasonAndEpisodeSerieRQ.getEpisode()))
            throw new SerieException(SerieStatusEnum.ERROR_FORMAT_REQUEST);
        return findByIdAndSeasonAndEpisodeSerieRQ;
    }

    /**
     * Metodo que permite construir la url del servicio.
     * @param object
     * @return {@link String}
     * @throws SerieException
     */
    @Override
    public String url(Object object) throws SerieException {
        FindByIdAndSeasonAndEpisodeSerieRQ findByIdAndSeasonAndEpisodeSerieRQ = (FindByIdAndSeasonAndEpisodeSerieRQ) object;
        tmdbUrl.setOperation(SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON_AND_EPISODE_NAME));
        SerieCommon.addProperties(tmdbUrl, tmdbUrl.getHost(), findByIdAndSeasonAndEpisodeSerieRQ.getIdSerie(), findByIdAndSeasonAndEpisodeSerieRQ.getSeason(), findByIdAndSeasonAndEpisodeSerieRQ.getEpisode(), tmdbUrl.getKey());
        return buildUrl(tmdbUrl);
    }
}
