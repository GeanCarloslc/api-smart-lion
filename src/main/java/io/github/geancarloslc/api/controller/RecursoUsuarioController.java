package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.RecursoUsuarioDto;
import io.github.geancarloslc.service.RecursoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recurso-usuario")
public class RecursoUsuarioController {

    @Autowired
    RecursoUsuarioService recursoUsuarioService;

    @GetMapping("/buscar-todos")
    public Page<RecursoUsuarioDto> buscarTodosRecursosUsuario(
            @RequestParam (required = false) String data,
            Pageable pageable
    ){
        RecursoUsuarioDto filtroRecursoUsuario = new RecursoUsuarioDto(data);
        return recursoUsuarioService.buscarTodosRecursosUsuario(filtroRecursoUsuario, pageable);
    }
}
