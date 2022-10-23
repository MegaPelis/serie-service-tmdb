package com.megapelis.serie.model.dto.request.generic;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase {@link Request}
 * @author sergio.barrios.
 */
@Getter
@Setter
public class Request implements Serializable {
    private String traceId;
    private String dateTime;
    private String service;
    private String operation;
    private List<RequestProperty> properties;
    private Object data;
}
