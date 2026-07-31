package com.arath.minierp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class EmpleadoEncontradoException extends RuntimeException {
    public EmpleadoEncontradoException(String mensaje){
        super(mensaje);
    }
}
