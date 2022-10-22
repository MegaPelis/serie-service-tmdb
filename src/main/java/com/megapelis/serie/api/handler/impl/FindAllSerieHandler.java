package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.util.CommonSerie;
import com.megapelis.serie.util.ConstantSerie;
import com.megapelis.serie.util.SerieException;

public class FindAllSerieHandler extends SerieHandler {

    @Override
    public Boolean validatePayload(Request request) throws SerieException{
        return true;
    }

    @Override
    public String url(Object object) throws SerieException {
        String host = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_HOST_NAME);
        String operation = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_NAME);
        String key = CommonSerie.getEnv(ConstantSerie.STRING_ENV_MEGAPELIS_TMDB_KEY_NAME);
        return CommonSerie.formatString(operation, host, key);
    }
}
