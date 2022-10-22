package com.megapelis.serie.util;

/**
 * Clase {@link ConstantSerie}
 * @author sergio.barrios.
 */
public class ConstantSerie {

    public static final boolean BOOLEAN_TRUE = true;
    public static final boolean BOOLEAN_FALSE = false;

    // Fecha
    public static final String STRING_DATE_ZONE = "America/Bogota";
    public static final String STRING_DATE_TIME_FORMAT = "yyyy/MM/dd hh.mm.ss";

    // Propiedades
    public static final String STRING_PROPERTY_TYPE_HANDLER_NAME = "typeHandler";
    public static final String STRING_PROPERTY_DEFAULT_NAME = "default";
    public static final String STRING_PROPERTY_DEFAULT_VALUE = "default";

    // Variables Entorno
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_NAME = "MEGAPELIS_TMDB_HOST";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_NAME = "MEGAPELIS_TMDB_HOST_SERIE";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_NAME = "MEGAPELIS_TMDB_HOST_SERIE_BY_ID";
    public static final String STRING_ENV_MEGAPELIS_TMDB_KEY_NAME = "MEGAPELIS_TMDB_KEY";

    // TMDB
    public static final boolean BOOLEAN_TMDB_OUTPUT = true;
    public static final String STRING_TMDB_METHOD_GET = "GET";
    public static final String STRING_TMDB_METHOD_POST = "POST";
    public static final String STRING_TMDB_PROPERTY_CONTENT_TYPE_NAME = "Content-Type";
    public static final String STRING_TMDB_PROPERTY_CONTENT_TYPE_VALUE = "application/json";

    private ConstantSerie(){}

}
