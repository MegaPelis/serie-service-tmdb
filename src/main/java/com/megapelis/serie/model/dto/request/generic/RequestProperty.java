package com.megapelis.serie.model.dto.request.generic;

import lombok.*;

import java.io.Serializable;

/**
 * Clase {@link RequestProperty}
 * @author sergio.barrios.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestProperty implements Serializable {

    private String name;
    private String value;
}
