package com.cristianortega.azure.domain.exception;

import lombok.Getter;

@Getter
public class AIException extends RuntimeException {

    private int code;
    public AIException(String message, int code) {
        super(message);
        this.code = code;
    }

}
