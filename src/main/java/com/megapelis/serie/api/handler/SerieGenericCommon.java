package com.megapelis.serie.api.handler;

import com.megapelis.serie.api.tmdb.ITMDBConnection;
import com.megapelis.serie.api.tmdb.impl.TMDBConnection;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.model.entity.TMDB;
import com.megapelis.serie.model.entity.TMDBUrl;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link SerieGenericCommon}
 * @author sergio.barrios.
 */
public class SerieGenericCommon {
    protected ITMDBConnection tmdb;
    protected String method;
    protected TMDBUrl tmdbUrl;

    public SerieGenericCommon(){
        this.tmdb = new TMDBConnection();
        this.method = SerieConstant.STRING_TMDB_METHOD_GET;
    }

    /**
     * Metodo que permite parsear el payload.
     * @param request
     * @param clazz
     * @return {@link T}
     * @param <T>
     * @throws SerieException
     */
    protected <T> T convertPayload(Request request, Class<T> clazz) throws SerieException{
        if(null == request || null == request.getData())
            throw new SerieException(SerieStatusEnum.ERROR_FORMAT_REQUEST);
        return SerieCommon.convertObjectToClass(request.getData(), clazz);
    }

    /**
     * Metodo que permite construir el objeto de tmdb url.
     * @return {@link TMDBUrl}
     * @throws SerieException
     */
    protected TMDBUrl buildTMBDUrl() throws SerieException {
        String host = SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_HOST_NAME);
        String key = SerieCommon.getEnv(SerieConstant.STRING_ENV_MEGAPELIS_TMDB_KEY_NAME);
        return TMDBUrl.builder()
                .host(host)
                .key(key)
                .method(method)
                .build();
    }

    /**
     * Metodo que permite construir la url de tmdb con los valores reemplazados.
     * @param tmdbUrl
     * @return {@link String}
     */
    protected String buildUrl(TMDBUrl tmdbUrl){
        return SerieCommon.formatString(tmdbUrl.getOperation(), tmdbUrl.getProperties());
    }

    /**
     * Metodo que permite construir el objeto de TMDB.
     * @param url
     * @return {@link TMDB}
     */
    protected TMDB tmdb(String url){
        TMDB tmdb = TMDB
                .builder()
                .url(url)
                .output(SerieConstant.BOOLEAN_TMDB_OUTPUT)
                .method(method)
                .property(new RequestProperty(SerieConstant.STRING_TMDB_PROPERTY_CONTENT_TYPE_NAME, SerieConstant.STRING_TMDB_PROPERTY_CONTENT_TYPE_VALUE))
                .build();
        SerieCommon.output(tmdb);
        return tmdb;
    }
}
