package com.megapelis.serie.model.dto.response.generic;

import lombok.*;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private UUID traceId;
    private String dateTime;
    private String service;
    private String operation;
    private ResponseStatus status;
    private Object data;
}
