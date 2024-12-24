package io.github.geancarloslc.api.advice;

import feign.Response;
import io.github.geancarloslc.api.dto.ExceptionDTO;

import io.github.geancarloslc.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
@Log4j2
public class GlobalExceptionAdviceHandler {

    private static final String LOG_SEPARATOR = "{} {} {} {}";


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest request) {

        logExternalResponseData(resourceNotFoundException.getResponse());

        log.error(LOG_SEPARATOR, resourceNotFoundException);

        return new ResponseEntity<>(new ExceptionDTO(
                HttpStatus.NOT_FOUND.value(),
                resourceNotFoundException.getExceptionEnum(),
                resourceNotFoundException.getMessage(),
                request.getServletPath(),
                resourceNotFoundException.getResponse(),
                Arrays.toString(resourceNotFoundException.getStackTrace())
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(Exception exception, HttpServletRequest request) {

        log.error(LOG_SEPARATOR, exception);

        return new ResponseEntity<>(new ExceptionDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                null,
                exception.getMessage(),
                request.getServletPath(),
                null,
                Arrays.toString(exception.getStackTrace())
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logExternalResponseData(Response response) {
        if (Objects.nonNull(response)) {
            log.error("{} {} {}", response.request().url(), response.status(), response.reason());
        }
    }

}
