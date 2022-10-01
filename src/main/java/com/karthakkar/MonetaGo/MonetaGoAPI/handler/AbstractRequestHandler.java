package com.karthakkar.MonetaGo.MonetaGoAPI.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * Abstract class implementing the RequestHandler. It defines the flow of operations that are needed to be done
 * while implementing different APIs.
 * @param <Request>
 */
@Slf4j
public abstract class AbstractRequestHandler<Request> implements RequestHandler<Request>{

    public Object handle(Request request) {
        logRequest(request);
        validateRequest(request);
        return doHandle(request);
    }

    public abstract void validateRequest(Request request);

    protected void logRequest(Request request) {
        if(request != null) {
            log.info(request.toString());
        } else {
            log.error("Request is null");
        }
    }

    protected abstract Object doHandle(Request request);
}
