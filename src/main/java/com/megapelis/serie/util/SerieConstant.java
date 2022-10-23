package com.megapelis.serie.util;

/**
 * Clase {@link SerieConstant}
 * @author sergio.barrios.
 */
public class SerieConstant {

    public static final boolean BOOLEAN_TRUE = true;
    public static final boolean BOOLEAN_FALSE = false;

    public static final int INTEGER_ONE = 1;
    public static final String STRING_COMMON_UTF8 = "UTF-8";

    // Fecha
    public static final String STRING_DATE_ZONE = "America/Bogota";
    public static final String STRING_DATE_TIME_FORMAT = "yyyy/MM/dd hh.mm.ss";

    // Propiedades
    public static final String STRING_PROPERTY_DEFAULT_NAME = "default";
    public static final String STRING_PROPERTY_DEFAULT_VALUE = "default";

    // Variables Entorno
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_NAME = "MEGAPELIS_TMDB_HOST";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_NAME = "MEGAPELIS_TMDB_HOST_SERIE";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_NAME = "MEGAPELIS_TMDB_HOST_SERIE_BY_ID";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON_NAME = "MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON_AND_EPISODE_NAME = "MEGAPELIS_TMDB_HOST_SERIE_BY_ID_AND_SEASON_AND_EPISODE";
    public static final String STRING_ENV_MEGAPELIS_TMDB_HOST_SERIE_POPULAR = "MEGAPELIS_TMDB_HOST_SERIE_POPULAR";
    public static final String STRING_ENV_MEGAPELIS_TMDB_KEY_NAME = "MEGAPELIS_TMDB_KEY";

    // SERVICIO
    public static final String STRING_SERVICE_NAME = "Serie";

    // TMDB
    public static final boolean BOOLEAN_TMDB_OUTPUT = true;
    public static final String STRING_TMDB_METHOD_GET = "GET";
    public static final String STRING_TMDB_METHOD_POST = "POST";
    public static final String STRING_TMDB_PROPERTY_CONTENT_TYPE_NAME = "Content-Type";
    public static final String STRING_TMDB_PROPERTY_CONTENT_TYPE_VALUE = "application/json";

    private SerieConstant(){}

}
