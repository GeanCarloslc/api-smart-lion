package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.MetaGastoDto;
import io.github.geancarloslc.api.dto.RecursosUsuarioDto;
import io.github.geancarloslc.service.MetaGastoService;
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
@RequestMapping("/api/meta-gasto")
public class MetaGastoController {

    @Autowired
    MetaGastoService metaGastoService;

    @GetMapping("/buscar-todas")
    public ResponseEntity<Page<MetaGastoDto>> buscarTodas(
            @RequestParam Long recursosUsuarioId,
            Pageable pageable
    ) {
        Page<MetaGastoDto> recursos = metaGastoService.buscarTodas(recursosUsuarioId, pageable);
        return ResponseEntity.ok(recursos);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> salvar(@RequestBody MetaGastoDto metaGastoDto) {
        metaGastoService.salvar(metaGastoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody MetaGastoDto metaGastoDto) {
        metaGastoService.atualizar(id, metaGastoDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody List<Long> ids) {
        metaGastoService.excluir(ids);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
