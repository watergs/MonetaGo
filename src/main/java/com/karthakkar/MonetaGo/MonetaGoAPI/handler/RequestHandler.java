package com.karthakkar.MonetaGo.MonetaGoAPI.handler;

/**
 * Generic Interface for handling the operations of API. All classes that handle the API implementation
 * must implement the interface.
 * @param <Request> - Generic Request object that can be re-used across different APIs.
 */
public interface RequestHandler<Request> {
    Object handle(Request request);
}
