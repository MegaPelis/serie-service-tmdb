package com.megapelis.serie.util;

import com.megapelis.serie.model.enums.SerieStatusEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase {@link SerieException}
 * @author sergio.barrios.
 */
@Getter
@Setter
public class SerieException extends Exception{
    private SerieStatusEnum status;

    public SerieException(SerieStatusEnum status){
        super(status.getMessageBackend());
        this.status = status;
    }
}
