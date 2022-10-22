package com.megapelis.serie.model.dto.request.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProperty implements Serializable {

    private String name;
    private String value;
}
