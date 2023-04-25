package com.gutjahr.funcionario.controller;

import com.gutjahr.funcionario.dto.ResponseDTO;
import com.gutjahr.funcionario.exception.Advertencia;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptionController {

    @ExceptionHandler({Advertencia.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO advertencia(ResponseDTO response, Advertencia ad) {
        response.setSuccess(false);
        response.setMessage(ad.getMessage());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO methodArgumentNotValidException(ResponseDTO response, MethodArgumentNotValidException e) {
        response.setSuccess(false);
        response.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return response;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO exception(ResponseDTO response, Exception ex) {
        response.setSuccess(false);
        response.setMessage("Ocorreu um problema ao tentar realizar a operação");
        return response;
    }
}
