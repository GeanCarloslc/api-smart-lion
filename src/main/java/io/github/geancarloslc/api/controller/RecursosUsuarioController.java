package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.RecursosUsuarioDto;
import io.github.geancarloslc.service.RecursosUsuarioService;
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
public class RecursosUsuarioController {

    @Autowired
    RecursosUsuarioService recursosUsuarioService;

    @GetMapping("/buscar-todos")
    public ResponseEntity<Page<RecursosUsuarioDto>> buscarTodos(Pageable pageable) {
        Page<RecursosUsuarioDto> recursos = recursosUsuarioService.buscarTodos(pageable);
        return ResponseEntity.ok(recursos);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> salvar(@RequestBody RecursosUsuarioDto recursosUsuarioDto) {
        recursosUsuarioService.salvar(recursosUsuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody RecursosUsuarioDto recursosUsuarioDto) {
        recursosUsuarioService.atualizar(id, recursosUsuarioDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody List<Long> ids) {
        recursosUsuarioService.excluir(ids);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
