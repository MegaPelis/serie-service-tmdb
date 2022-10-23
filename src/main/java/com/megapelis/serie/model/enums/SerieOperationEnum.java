package com.megapelis.serie.model.enums;

import com.megapelis.serie.App;
import com.megapelis.serie.util.SerieException;
import lombok.Getter;

import java.util.Arrays;

/**
 * Clase {@link SerieOperationEnum}
 * @author sergio.barrios.
 */
@Getter
public enum SerieOperationEnum {
    FIND_BY_ID("findById"),
    FIND_BY_ID_AND_SEASON("findAllByIdAndSeason"),
    FIND_BY_ID_AND_SEASON_AND_EPISODE("findAllByIdAndSeasonAndEpisode"),
    FIND_ALL_BY_POPULAR("findAllByPopular");

    private String name;

    SerieOperationEnum(String name){
        this.name = name;
    }

    /**
     * Metodo que permite validar si existe esa operación
     * @param name
     * @return {@link SerieOperationEnum}
     * @throws SerieException
     */
    public static SerieOperationEnum isValid(String name) throws SerieException {
        return Arrays.stream(SerieOperationEnum.values())
                .filter(operationEnum -> operationEnum.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new SerieException(SerieStatusEnum.ERROR_SERVICE_OR_OPERATION));
    }
}
