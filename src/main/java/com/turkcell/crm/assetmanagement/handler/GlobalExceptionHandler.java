package com.turkcell.crm.assetmanagement.handler;

import com.turkcell.crm.assetmanagement.dto.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {

        Response response = Response
                .builder()
                .errorDescription(ex.getMessage())
                .httpStatus(HttpStatus.CONFLICT.value())
                .build();

        ex.printStackTrace();

        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleNullPointerExceptions(Exception ex, WebRequest request) {

        Response response = Response
                .builder()
                .errorDescription(ex.getMessage() == null ? "null reference" : ex.getMessage())
                .httpStatus(HttpStatus.CONFLICT.value())
                .build();

        ex.printStackTrace();

        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
