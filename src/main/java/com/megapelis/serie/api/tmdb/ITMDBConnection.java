package com.megapelis.serie.api.tmdb;

import com.megapelis.serie.api.model.entity.TMDB;

public interface ITMDBConnection {

    Object execute(TMDB tmdb);
}
