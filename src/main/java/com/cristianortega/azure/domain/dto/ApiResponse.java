package com.cristianortega.azure.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

    private int statusCode;
    private String message;
    private T data;
    private List<String> errors;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private ApiResponse(int statusCode, String message, T data, List<String> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(int statusCode, String messageCode, T data, MessageSource messageSource) {
        return new ApiResponse<>(statusCode, getMessage(messageSource, messageCode), data, null);
    }

    public static <T> ApiResponse<T> error(int statusCode, String messageCode, List<String> errors, MessageSource messageSource) {
        return new ApiResponse<>(statusCode, getMessage(messageSource, messageCode), null, errors);
    }

    private static String getMessage(MessageSource messageSource, String messageCode) {
        return messageSource.getMessage(messageCode, null, messageCode, LocaleContextHolder.getLocale());
    }

}