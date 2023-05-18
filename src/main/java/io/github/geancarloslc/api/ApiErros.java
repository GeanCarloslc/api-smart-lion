package io.github.geancarloslc.api;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class ApiErros {

    @Getter
    private List<String> errors;

    public ApiErros(String mensaagemErro){
        this.errors = Arrays.asList(mensaagemErro);
    }
}
