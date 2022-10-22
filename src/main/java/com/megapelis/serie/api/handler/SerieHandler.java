package com.megapelis.serie.api.handler;

import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.api.model.dto.response.generic.Response;
import com.megapelis.serie.api.model.entity.TMDB;
import com.megapelis.serie.api.tmdb.ITMDBConnection;
import com.megapelis.serie.api.tmdb.impl.TMDBConnection;
import com.megapelis.serie.util.CommonSerie;
import com.megapelis.serie.util.ConstantSerie;
import com.megapelis.serie.util.SerieException;

public abstract class SerieHandler {

    protected ITMDBConnection tmdbConnection;
    protected String method;

    public SerieHandler(){
        this.tmdbConnection = new TMDBConnection();
        this.method = ConstantSerie.STRING_TMDB_METHOD_POST;
    }

    public Response execute(Request request){
        Response response = null;
        try {
            Object object = validatePayload(request);
            String url = url(object);
            TMDB tmdb = tmdb(url);
            tmdbConnection.execute(tmdb);
        } catch (SerieException exception) {
            response = CommonSerie.buildResponse(request, exception.getStatus());
        }
        return response;
    }

    public abstract Object validatePayload(Request request) throws SerieException;

    public abstract String url(Object object) throws SerieException;

    private TMDB tmdb(String url){
        TMDB tmdb = TMDB
                .builder()
                .url(url)
                .output(ConstantSerie.BOOLEAN_TMDB_OUTPUT)
                .method(method)
                .property(new RequestProperty(ConstantSerie.STRING_TMDB_PROPERTY_CONTENT_TYPE_NAME, ConstantSerie.STRING_TMDB_PROPERTY_CONTENT_TYPE_VALUE))
                .build();
        CommonSerie.output(tmdb);
        return tmdb;
    }
}
