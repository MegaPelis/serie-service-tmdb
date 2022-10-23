package com.megapelis.serie.model.dto.response;

import lombok.*;

/**
 * Clase {@link Response}
 * @author sergio.barrios.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String traceId;
    private String dateTime;
    private String service;
    private String operation;
    private ResponseStatus status;
    private Object data;
}
