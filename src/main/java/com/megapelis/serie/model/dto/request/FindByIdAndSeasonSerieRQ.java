package com.megapelis.serie.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase {@link FindByIdAndSeasonSerieRQ}
 * @author sergio.barrios.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdAndSeasonSerieRQ {
    private String idSerie;
    private String season;
}
