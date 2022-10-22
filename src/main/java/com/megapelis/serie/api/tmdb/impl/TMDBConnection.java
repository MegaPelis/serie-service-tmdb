package com.megapelis.serie.api.tmdb.impl;

import com.megapelis.serie.api.model.entity.TMDB;
import com.megapelis.serie.api.tmdb.ITMDBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMDBConnection implements ITMDBConnection {

    @Override
    public Object execute(TMDB tmdb) {
        try {
            URL url = new URL(tmdb.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(tmdb.isOutput());
            connection.setRequestMethod(tmdb.getMethod());
            connection.setRequestProperty(tmdb.getProperty().getName(), tmdb.getProperty().getValue());
            read(connection);
        }catch (IOException exception){
            System.out.println(exception);
        }
        return null;
    }


    private void read(HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
    }
}
