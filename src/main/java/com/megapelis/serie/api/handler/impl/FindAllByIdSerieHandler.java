package com.megapelis.serie.api.handler.impl;

import com.google.gson.Gson;
import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.api.model.dto.request.FindAllByIdSerieRQ;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.api.model.dto.response.generic.Response;
import com.megapelis.serie.api.model.entity.TMDB;
import com.megapelis.serie.api.model.enums.StatusEnum;
import com.megapelis.serie.api.tmdb.ITMDBConnection;
import com.megapelis.serie.api.tmdb.impl.TMDBConnection;
import com.megapelis.serie.util.CommonSerie;
import com.megapelis.serie.util.ConstantSerie;
import com.megapelis.serie.util.SerieException;

public class FindAllByIdSerieHandler extends SerieHandler {

    @Override
    public Object validatePayload(Request request) throws SerieException{
        FindAllByIdSerieRQ findAllByIdSerieRQ = CommonSerie.convertObjectToClass(request.getData(), FindAllByIdSerieRQ.class);
        if(!CommonSerie.isValidString(findAllByIdSerieRQ.getIdSerie()))
            throw new SerieException(StatusEnum.ERROR_FORMAT_REQUEST);
        return findAllByIdSerieRQ;
    }

    @Override
    public String url(Object object) throws SerieException {
        FindAllByIdSerieRQ findAllByIdSerieRQ = (FindAllByIdSerieRQ) object;
        String host = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_HOST_NAME);
        String operation = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_NAME);
        String key = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_KEY_NAME);
        method = ConstantSerie.STRING_TMDB_METHOD_GET;
        return CommonSerie.formatString(operation, host, findAllByIdSerieRQ.getIdSerie(), key);
    }
}
