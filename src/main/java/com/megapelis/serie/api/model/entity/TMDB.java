package com.megapelis.serie.api.model.entity;

import com.megapelis.serie.api.model.dto.request.generic.RequestProperty;
import lombok.*;

import java.io.Serializable;

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
