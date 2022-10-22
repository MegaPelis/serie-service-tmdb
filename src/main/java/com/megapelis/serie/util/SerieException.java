package com.megapelis.serie.util;

import com.megapelis.serie.api.model.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase {@link SerieException}
 * @author sergio.barrios.
 */
@Getter
@Setter
public class SerieException extends Exception{
    private StatusEnum status;

    public SerieException(StatusEnum status){
        super(status.getMessageBackend());
        this.status = status;
    }
}
