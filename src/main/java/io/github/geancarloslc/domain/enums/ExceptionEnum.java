package io.github.geancarloslc.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ExceptionEnum {
    UNKNOWN(0, "Erro não especificado!"),
    HASH_EXPIRED(1, "Tempo para troca ou reset de senha expirado, tente novamente."),
    EXTERNAL_ERROR(2, "Houve falha na comunicação com o serviço externo: s%"),
    EXTERNAL_GRAPHQL_QUERY_ERROR(3, "Erro ao tentar executar query GRAPHQL em um serviço externo!");

    private final Integer code;
    private final String description;

    ExceptionEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator
    public static ExceptionEnum fromValue(Integer code) {
        return Arrays.stream(values())
                .filter(e -> e.code.equals(code))
                .findFirst()
                .orElse(ExceptionEnum.UNKNOWN);
    }

    @JsonCreator
    public static ExceptionEnum fromValue(String description) {
        return Arrays.stream(values())
                .filter(e -> e.description.equals(description))
                .findFirst()
                .orElse(ExceptionEnum.UNKNOWN);
    }

    @JsonCreator
    public static Integer fromValue(ExceptionEnum exceptionEnum) {
        return Arrays.stream(values())
                .filter(e -> e.equals(exceptionEnum))
                .findFirst()
                .orElse(ExceptionEnum.UNKNOWN).getCode();
    }

}
