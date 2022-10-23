package com.megapelis.serie.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * Clase {@link TMDBUrl}
 * @author sergio.barrios.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TMDBUrl implements Serializable {
    private String host;
    private String operation;
    private String key;
    private String method;
    private String [] properties;
}
