package io.github.geancarloslc.service;
import io.github.geancarloslc.api.dto.RecursoUsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecursoUsuarioService {
    Page<RecursoUsuarioDto> buscarTodosRecursosUsuario(RecursoUsuarioDto filtroRecursoUsuarioRequest, Pageable pageable);
}
