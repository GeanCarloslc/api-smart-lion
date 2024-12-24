package io.github.geancarloslc.service;
import io.github.geancarloslc.api.dto.MetaGastoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MetaGastoService {
    Page<MetaGastoDto> buscarTodas(Long recursosUsuarioId, Pageable pageable);

    void salvar(MetaGastoDto metaGastoDto);

    void atualizar(Long id, MetaGastoDto metaGastoDto);

    void excluir(List<Long> ids);
}
