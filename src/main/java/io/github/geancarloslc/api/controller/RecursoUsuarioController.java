package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.RecursoUsuarioDto;
import io.github.geancarloslc.service.RecursoUsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/recurso-usuario")
public class RecursoUsuarioController {

    @Autowired
    RecursoUsuarioService recursoUsuarioService;

    @GetMapping("/buscar-todos")
    public ResponseEntity<Page<RecursoUsuarioDto>> buscarTodos(Pageable pageable) {
        Page<RecursoUsuarioDto> recursos = recursoUsuarioService.buscarTodos(pageable);
        return ResponseEntity.ok(recursos);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> salvar(@RequestBody RecursoUsuarioDto recursoUsuarioDto) {
        try {
            recursoUsuarioService.salvar(recursoUsuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Erro ao salvar recursos do usuario" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody List<Long> ids) {
        try {
            recursoUsuarioService.excluir(ids);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            log.error("Erro ao excluir recursos do usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
