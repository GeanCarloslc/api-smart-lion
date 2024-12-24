package io.github.geancarloslc.api.dto;

import feign.Response;
import io.github.geancarloslc.domain.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class ExceptionDTO {

    private Integer httpStatusCode;

    private Integer code;

    private String message;

    private String path;

    private String externalErrorPath;

    private Integer externalHttpStatusCode;

    private String externalErrorReason;

    private String trace;

    private final String timestamp = LocalDateTime.now().toString();

    public ExceptionDTO(Integer httpStatusCode, ExceptionEnum exceptionEnum, String errorMessage, String errorPath) {
        this.httpStatusCode = httpStatusCode;
        this.code = Objects.isNull(exceptionEnum) ? ExceptionEnum.UNKNOWN.getCode() : ExceptionEnum.fromValue(exceptionEnum);
        this.message = errorMessage;
        this.path = errorPath;
    }

    public ExceptionDTO(Integer httpStatusCode, ExceptionEnum exceptionEnum, String errorMessage, String errorPath,
                        Response response, String trace) {
        this.httpStatusCode = httpStatusCode;
        this.code = Objects.isNull(exceptionEnum) ? ExceptionEnum.UNKNOWN.getCode() : ExceptionEnum.fromValue(exceptionEnum);
        this.message = errorMessage;
        this.path = errorPath;
        this.externalErrorPath = Objects.nonNull(response) ? response.request().url() : null;
        this.externalHttpStatusCode = Objects.nonNull(response) ? response.status() : null;
        this.externalErrorReason = Objects.nonNull(response) ? response.reason() : null;
        this.trace = trace;
    }



}
