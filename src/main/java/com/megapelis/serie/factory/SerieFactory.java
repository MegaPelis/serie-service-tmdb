package com.megapelis.serie.factory;

import com.megapelis.serie.handler.ISerieHandler;
import com.megapelis.serie.handler.impl.FindAllByGenderSerieHandler;
import com.megapelis.serie.handler.impl.FindAllBySeasonAndChapterSerieHandler;
import com.megapelis.serie.handler.impl.FindAllBySeasonSerieHandler;
import com.megapelis.serie.handler.impl.FindAllSerieHandler;
import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.request.generic.RequestProperty;
import com.megapelis.serie.model.dto.response.generic.Response;
import com.megapelis.serie.util.CommonSerie;
import com.megapelis.serie.util.ConstantSerie;
import com.megapelis.serie.util.enums.StatusEnum;
import com.megapelis.serie.util.enums.TypeHandlerEnum;

public class SerieFactory {

    private SerieFactory(){
    }

    /**
     *
     * @param request
     * @return
     */
    public static Response handler(Request request) {
        RequestProperty property = CommonSerie.findByNameProperty(request.getProperties(), ConstantSerie.STRING_PROPERTY_TYPE_HANDLER_NAME, ConstantSerie.BOOLEAN_TRUE);
        ISerieHandler handler;
        try{
            switch (TypeHandlerEnum.valueOf(property.getName())){
                case FIND_BY_ALL:
                    handler = new FindAllSerieHandler();
                    break;
                case FIND_BY_ALL_BY_GENDER:
                    handler = new FindAllByGenderSerieHandler();
                    break;
                case FIND_BY_ALL_BY_SEASON:
                    handler = new FindAllBySeasonSerieHandler();
                    break;
                default:
                    handler = new FindAllBySeasonAndChapterSerieHandler();
                    break;
            }
        }catch (IllegalArgumentException exception){
            return CommonSerie.buildResponse(request, StatusEnum.ERROR_SERVICE_OR_OPERATION);
        }
        return handler.execute(request);
    }
}
