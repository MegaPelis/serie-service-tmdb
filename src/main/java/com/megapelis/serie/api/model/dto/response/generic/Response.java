package com.megapelis.serie.api.model.dto.response.generic;

import lombok.*;

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
