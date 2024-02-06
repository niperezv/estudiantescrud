package com.store.storebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcerNotFoundException extends RuntimeException{
    public ResourcerNotFoundException(String message){
        super(message);
    }
}
