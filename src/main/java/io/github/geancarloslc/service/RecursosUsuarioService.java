package io.github.geancarloslc.service;
import io.github.geancarloslc.api.dto.RecursosUsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecursosUsuarioService {
    Page<RecursosUsuarioDto> buscarTodos(Pageable pageable);

    void salvar(RecursosUsuarioDto recursosUsuarioDto);

    void excluir(List<Long> ids);

    void atualizar(Long id, RecursosUsuarioDto recursosUsuarioDto);
}
