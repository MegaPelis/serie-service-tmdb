package com.megapelis.serie.api.tmdb;

import com.google.gson.JsonObject;
import com.megapelis.serie.model.entity.TMDB;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link ITMDBConnection}
 * @author sergio.barrios.
 */
public interface ITMDBConnection {

    /**
     * Metodo que permite realizar la consulta TMDB.
     * @param tmdb
     * @return {@link JsonObject}
     * @throws SerieException
     */
    JsonObject execute(TMDB tmdb) throws SerieException;
}
