package com.megapelis.serie.api.tmdb.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megapelis.serie.model.entity.TMDB;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.api.tmdb.ITMDBConnection;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieConstant;
import com.megapelis.serie.util.SerieException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase {@link TMDBConnection}
 * @author sergio.barrios.
 */
public class TMDBConnection implements ITMDBConnection {

    /**
     * Metodo que permite realizar la consulta TMDB.
     * @param tmdb
     * @return {@link JsonObject}
     * @throws SerieException
     */
    @Override
    public JsonObject execute(TMDB tmdb) throws SerieException {
        try {
            URL url = new URL(tmdb.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(tmdb.isOutput());
            connection.setRequestMethod(tmdb.getMethod());
            connection.setRequestProperty(tmdb.getProperty().getName(), tmdb.getProperty().getValue());
            return read(connection);
        }catch (IOException exception){
            SerieCommon.output(exception);
            throw new SerieException(SerieStatusEnum.ERROR_CONNECT_TMDB_FORMAT);
        }catch (Exception exception){
            SerieCommon.output(exception);
            throw new SerieException(SerieStatusEnum.ERROR_CONNECT_TMDB);
        }
    }

    /**
     * Metodo que permite leer la respuesta de TMDB.
     * @param connection
     * @return {@link JsonObject}
     * @throws IOException
     */
    private JsonObject read(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, SerieConstant.STRING_COMMON_UTF8));
        StringBuilder stringBuilder = new StringBuilder();
        String output;
        while (null != (output = bufferedReader.readLine())) {
            stringBuilder.append(output);
        }
        return JsonParser.parseString( stringBuilder.toString()).getAsJsonObject();
    }
}
