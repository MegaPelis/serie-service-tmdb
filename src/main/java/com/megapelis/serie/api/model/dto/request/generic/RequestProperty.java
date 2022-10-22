package com.megapelis.serie.api.model.dto.request.generic;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestProperty implements Serializable {

    private String name;
    private String value;
}
