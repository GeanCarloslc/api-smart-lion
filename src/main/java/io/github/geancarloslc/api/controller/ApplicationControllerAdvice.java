package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.ApiErros;
import io.github.geancarloslc.exception.PedidoNaoEncontradoException;
import io.github.geancarloslc.exception.RegraNegocioException;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    // Aponta que o metodo é um trator de erros
    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErros handleRegraNegocioException(RegraNegocioException regraNegocioException){
        String mensagemErro = regraNegocioException.getMessage();

        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErros handlePedidoNotFoundExecption(PedidoNaoEncontradoException pedidoNaoEncontradoException){
        String mensagemErro = pedidoNaoEncontradoException.getMessage();

        return new ApiErros(mensagemErro);
    }

}
