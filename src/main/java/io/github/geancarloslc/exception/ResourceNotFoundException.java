package io.github.geancarloslc.exception;

import feign.Response;
import io.github.geancarloslc.domain.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    ExceptionEnum exceptionEnum;

    Response response;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ResourceNotFoundException(String message, Throwable cause, ExceptionEnum exceptionEnum) {
        super(message, cause);
        this.exceptionEnum = exceptionEnum;
    }

    public ResourceNotFoundException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public ResourceNotFoundException(Throwable cause, ExceptionEnum exceptionEnum) {
        super("Recurso não encontrado!", cause);
        this.exceptionEnum = exceptionEnum;
    }

    public ResourceNotFoundException(String message, ExceptionEnum exceptionEnum, Response response) {
        super(message);
        this.exceptionEnum = exceptionEnum;
        this.response = response;
    }
}