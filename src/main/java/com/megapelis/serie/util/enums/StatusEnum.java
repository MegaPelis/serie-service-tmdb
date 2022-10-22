package com.megapelis.serie.util.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    SUCCESS("200", "Success"),
    ERROR("2", ""),
    ERROR_SERVICE_OR_OPERATION("2", ""),
    ERROR_FORMAT_REQUEST("2", ""),
    ERROR_NOT_CONTENT("2", "");

    private final String code;
    private final String message;

    StatusEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
