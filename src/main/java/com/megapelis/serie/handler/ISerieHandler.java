package com.megapelis.serie.handler;

import com.megapelis.serie.model.dto.request.generic.Request;
import com.megapelis.serie.model.dto.response.generic.Response;

public interface ISerieHandler {

    Response execute(Request request);
}
