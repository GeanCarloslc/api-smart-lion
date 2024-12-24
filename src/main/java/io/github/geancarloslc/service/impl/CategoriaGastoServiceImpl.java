package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.CategoriaGastoDto;
import io.github.geancarloslc.domain.entity.CategoriaGasto;
import io.github.geancarloslc.domain.repository.CategoriaGastoRepository;
import io.github.geancarloslc.service.CategoriaGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaGastoServiceImpl implements CategoriaGastoService {

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    @Override
    public List<CategoriaGastoDto> buscarDadosDropdown() {
        return CategoriaGasto.toDto(categoriaGastoRepository.findAll());
    }

}
