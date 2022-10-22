package com.megapelis.serie.api.factory;

import com.megapelis.serie.api.handler.SerieHandler;
import com.megapelis.serie.api.handler.impl.*;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.api.model.dto.response.generic.Response;
import com.megapelis.serie.util.CommonSerie;
import com.megapelis.serie.util.ConstantSerie;
import com.megapelis.serie.api.model.enums.StatusEnum;
import com.megapelis.serie.api.model.enums.TypeHandlerEnum;
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
        CommonSerie.output(request);
        Response response = null;
        SerieHandler handler = null;
        try {
            CommonSerie.isValidRequest(request);
            RequestProperty property = CommonSerie.findByNameProperty(request.getProperties(), ConstantSerie.STRING_PROPERTY_TYPE_HANDLER_NAME, ConstantSerie.BOOLEAN_TRUE);
            switch (TypeHandlerEnum.valueOf(property.getValue())){
                case FIND_ALL:
                    handler = new FindAllSerieHandler();
                    break;
                case FIND_ALL_BY_ID:
                    handler = new FindAllByIdSerieHandler();
                    break;
                case FIND_ALL_BY_GENDER:
                    handler = new FindAllByGenderSerieHandler();
                    break;
                case FIND_ALL_BY_SEASON:
                    handler = new FindAllBySeasonSerieHandler();
                    break;
                default:
                    handler = new FindAllBySeasonAndChapterSerieHandler();
                    break;
            }
        } catch (IllegalArgumentException exception){
            response =  CommonSerie.buildResponse(request, StatusEnum.ERROR_SERVICE_OR_OPERATION);
        }catch (SerieException e) {
            response =  CommonSerie.buildResponse(request, e.getStatus());
        }
        if(null == response && null != handler)
            response = handler.execute(request);
        CommonSerie.output(response);
        return response;
    }
}
