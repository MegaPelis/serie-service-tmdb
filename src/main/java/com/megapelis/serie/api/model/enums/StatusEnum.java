package com.megapelis.serie.api.model.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum StatusEnum {

    SUCCESS("200", "La petición se ha procesado exitosamente!", "Super todo ha salido bien!"),
    ERROR("500", "No se ha procesado la petición.", "Lo sentimos hemos tenido una falla, vuelva a intentar mas tarde."),
    ERROR_ENV("409", "No se ha procesado el valor de la variable de entorno", "Ouch, lamentamos que haya ocurrido esto."),
    ERROR_ENV_NOT_CONTENT("404", "No fue encontrado el valor de la variable de entorno", "Lo sentimos hemos tenido una falla, vuelva a intentar mas tarde."),
    ERROR_SERVICE_OR_OPERATION("404", "No fue encontrado ningún servicio.", "Esperamos estar pronto para ti!"),
    ERROR_FORMAT_REQUEST("400", "El formato de la petición no es el esperado.", "Lo sentimos hemos tenido una falla, vuelva a intentar mas tarde.");

    private final String code;
    private final String messageBackend;
    private final String messageFrontend;

    StatusEnum(String code, String messageBackend, String messageFrontend){
        this.code = code;
        this.messageBackend = messageBackend;
        this.messageFrontend = messageFrontend;
    }
}
