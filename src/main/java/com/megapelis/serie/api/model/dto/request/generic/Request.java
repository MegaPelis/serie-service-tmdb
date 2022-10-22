package com.megapelis.serie.api.model.dto.request.generic;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Request implements Serializable {
    private String traceId;
    private String dateTime;
    private String service;
    private String operation;
    private List<RequestProperty> properties;
    private Object data;

    public List<RequestProperty> getProperties(){
        if(null == properties){
            properties = new ArrayList<RequestProperty>();
        }
        return  properties;
    }
}
