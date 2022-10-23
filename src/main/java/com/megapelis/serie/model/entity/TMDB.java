package com.megapelis.serie.model.entity;

import com.megapelis.serie.model.dto.request.generic.RequestProperty;
import lombok.*;

import java.io.Serializable;

/**
 * Clase {@link TMDB}
 * @author sergio.barrios.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TMDB implements Serializable {
    private String url;
    private String method;
    private boolean output;
    private RequestProperty property;
}
