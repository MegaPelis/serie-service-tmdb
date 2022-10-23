package com.megapelis.serie.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase {@link FindByIdAndSeasonAndEpisodeSerieRQ}
 * @author sergio.barrios.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdAndSeasonAndEpisodeSerieRQ {
    private String idSerie;
    private String season;
    private String episode;
}
