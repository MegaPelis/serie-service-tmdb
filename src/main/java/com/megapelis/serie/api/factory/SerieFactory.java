package com.megapelis.serie.api.factory;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.api.handler.impl.*;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.response.Response;
import com.megapelis.serie.model.enums.SerieOperationEnum;
import com.megapelis.serie.model.enums.SerieStatusEnum;
import com.megapelis.serie.util.SerieCommon;
import com.megapelis.serie.util.SerieException;

/**
 * Clase {@link SerieFactory}
 * @author sergio.barrios.
 */
public class SerieFactory {

    private SerieFactory(){
    }

    /**
     * Fabrica que permite ejecutar mediante la operacion.
     * @param request
     * @return {@link Response}
     */
    public static Response handler(Request request) {
        SerieCommon.output(request);
        Response response = null;
        SerieHandler handler = null;
        try {
            SerieCommon.isValidRequest(request);
            switch (SerieOperationEnum.isValid(request.getOperation())){
                case FIND_BY_ID:
                    handler = new FindByIdSerieHandler();
                    break;
                case FIND_BY_ID_AND_SEASON:
                    handler = new FindByIdAndSeasonSerieHandler();
                    break;
                case FIND_BY_ID_AND_SEASON_AND_EPISODE:
                    handler = new FindByIdSeasonAndEpisodeSerieHandler();
                    break;
                case FIND_ALL_BY_POPULAR:
                    handler = new FindAllByPopularSerieHandler();
                    break;
                default:
                    response =  SerieCommon.buildResponse(request, SerieStatusEnum.ERROR);
                    break;
            }
        } catch (SerieException e) {
            response =  SerieCommon.buildResponse(request, e.getStatus());
        }
        if(null == response && null != handler)
            response = handler.execute(request);
        SerieCommon.output(response);
        return response;
    }
}
