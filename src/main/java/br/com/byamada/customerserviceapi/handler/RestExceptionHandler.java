package br.com.byamada.customerserviceapi.handler;

import br.com.byamada.customerserviceapi.exception.BadRequestException;
import br.com.byamada.customerserviceapi.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handlerBadRequest(BadRequestException exp){
        return new ResponseEntity<>(
                ErrorMessage.builder()
                .error("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exp.getMessage())
                .developerMessage(exp.getClass().getName())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }

}
