package com.megapelis.serie;

import com.megapelis.serie.api.factory.SerieFactory;
import com.megapelis.serie.api.model.dto.request.generic.Request;
import com.megapelis.serie.api.model.dto.response.generic.Response;

/**
 * Hello world!
 *
 */
public class App 
{

    /**
     *
     * @param request
     * @return
     */
    public Response handler(Request request){
        return SerieFactory.handler(request);
    }
}
