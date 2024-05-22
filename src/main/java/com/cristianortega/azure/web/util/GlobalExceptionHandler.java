package com.cristianortega.azure.web.util;

import com.cristianortega.azure.domain.dto.ApiResponse;
import com.cristianortega.azure.domain.exception.AIException;
import com.cristianortega.azure.domain.variable.MessageCode;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(AIException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(AIException ex, WebRequest request) {
        ApiResponse<Void> response = ApiResponse.error(ex.getCode(), ex.getMessage(), null, messageSource);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(Exception ex, WebRequest request) {
        ApiResponse<Void> response = ApiResponse.error(HttpStatus.BAD_REQUEST.value(), MessageCode.ERROR, null, messageSource);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
