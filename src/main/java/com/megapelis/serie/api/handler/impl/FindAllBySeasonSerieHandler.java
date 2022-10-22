package com.megapelis.serie.api.handler.impl;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.response.generic.Response;
import com.megapelis.serie.api.model.entity.TMDB;
import com.megapelis.serie.util.SerieException;

public class FindAllBySeasonSerieHandler extends SerieHandler{
    @Override
    public Object validatePayload(Request request) throws SerieException {
        return null;
    }

    @Override
    public String url(Object object) throws SerieException {
        return null;
    }
}
