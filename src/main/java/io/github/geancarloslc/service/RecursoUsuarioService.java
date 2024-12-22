package io.github.geancarloslc.service;
import io.github.geancarloslc.api.dto.RecursoUsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecursoUsuarioService {
    Page<RecursoUsuarioDto> buscarTodos(Pageable pageable);

    void salvar(RecursoUsuarioDto recursoUsuarioDto);

    void excluir(List<Long> ids);
}
