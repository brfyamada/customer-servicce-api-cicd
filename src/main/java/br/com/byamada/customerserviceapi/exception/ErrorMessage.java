package br.com.byamada.customerserviceapi.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {
    private String error;
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String developerMessage;
}
