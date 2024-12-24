package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.MetaGastoDto;
import io.github.geancarloslc.domain.entity.CategoriaGasto;
import io.github.geancarloslc.domain.entity.MetaGasto;
import io.github.geancarloslc.domain.repository.MetaGastoRepository;
import io.github.geancarloslc.exception.ResourceNotFoundException;
import io.github.geancarloslc.service.MetaGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaGastoServiceImpl implements MetaGastoService {

    @Autowired
    private MetaGastoRepository metaGastoRepository;

    @Override
    public Page<MetaGastoDto> buscarTodas(Long recursosUsuarioId, Pageable pageable) {
        Page<MetaGasto> metaGastoPage =
                metaGastoRepository.buscarTodasMetas(recursosUsuarioId, pageable);

        if (metaGastoPage.isEmpty()) {
            return new PageImpl<>(new ArrayList<>());
        }

        return new MetaGastoDto().toPageObjectDto(metaGastoPage);
    }

    @Override
    @Transactional
    public void salvar(MetaGastoDto metaGastoDto) {
        MetaGasto metaGasto = new MetaGasto(
                metaGastoDto.getCategoriaGastoDto().getId(),
                metaGastoDto.getValorMeta(),
                metaGastoDto.getRecursosUsuarioId());

        metaGastoRepository.save(metaGasto);
    }

    @Override
    @Transactional
    public void atualizar(Long id, MetaGastoDto metaGastoDto) {
        MetaGasto metaGasto = metaGastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meta de gasto não encontrada com ID: " + id));

        metaGasto.setCategoriaGasto(new CategoriaGasto(metaGastoDto.getCategoriaGastoDto().getId()));
        metaGasto.setValorMeta(metaGastoDto.getValorMeta());
        metaGasto.editado();

        metaGastoRepository.save(metaGasto);
    }

    @Override
    @Transactional
    public void excluir(List<Long> ids) {
        metaGastoRepository.deleteAllById(ids);
    }

}
