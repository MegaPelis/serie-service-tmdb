package com.megapelis.serie.api.model.dto.response.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus implements Serializable {
    private String code;
    private String messageBackend;
    private String messageFrontend;
}
