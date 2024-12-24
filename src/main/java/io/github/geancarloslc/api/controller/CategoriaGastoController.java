package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.CategoriaGastoDto;
import io.github.geancarloslc.service.CategoriaGastoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/categoria-gasto")
public class CategoriaGastoController {

    @Autowired
    CategoriaGastoService categoriaGastoService;

    @GetMapping("/buscar-dados-dropdown")
    public ResponseEntity<List<CategoriaGastoDto>> buscarDadosDropdown() {
        List<CategoriaGastoDto> categoriaGastoDtoLista = categoriaGastoService.buscarDadosDropdown();
        return ResponseEntity.ok(categoriaGastoDtoLista);
    }

}
