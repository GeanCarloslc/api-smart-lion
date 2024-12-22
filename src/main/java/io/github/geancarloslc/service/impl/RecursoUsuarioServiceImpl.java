package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.RecursoUsuarioDto;
import io.github.geancarloslc.domain.entity.RecursosUsuario;
import io.github.geancarloslc.domain.entity.Usuario;
import io.github.geancarloslc.domain.repository.RecursoUsuarioRepository;
import io.github.geancarloslc.service.RecursoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecursoUsuarioServiceImpl implements RecursoUsuarioService {

    @Autowired
    private RecursoUsuarioRepository recursoUsuarioRepository;

    @Override
    public Page<RecursoUsuarioDto> buscarTodos(Pageable pageable) {
        RecursosUsuario recursosUsuario = new RecursosUsuario();
        recursosUsuario.setUsuario(new Usuario(1L));
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        //ExampleMatcher.StringMatcher.CONTAINING, similar ao like do SQL
        Example<RecursosUsuario> exampleRecursosUsuario = Example.of(recursosUsuario, exampleMatcher);
        Page<RecursosUsuario> recursosUsuarioPage = recursoUsuarioRepository.findAll(exampleRecursosUsuario, pageable);

        return converteRecursoUsuarioPageDto(recursosUsuarioPage);
    }

    @Override
    public void salvar(RecursoUsuarioDto recursoUsuarioDto) {
        RecursosUsuario recursosUsuario = new RecursosUsuario(
                recursoUsuarioDto.getId(),
                recursoUsuarioDto.getUsuarioDto().getId(),
                recursoUsuarioDto.getData(),
                recursoUsuarioDto.getRenda());

        recursoUsuarioRepository.save(recursosUsuario);
    }

    @Override
    public void excluir(List<Long> ids) {
        recursoUsuarioRepository.deleteAllById(ids);
    }

    private Page<RecursoUsuarioDto> converteRecursoUsuarioPageDto(Page<RecursosUsuario> recursosUsuarioPage) {
        if (recursosUsuarioPage.isEmpty()) {
            return new PageImpl<>(new ArrayList<RecursoUsuarioDto>());
        }
        RecursoUsuarioDto recursoUsuarioDto = new RecursoUsuarioDto();
        return recursoUsuarioDto.toPageObjectDto(recursosUsuarioPage);
    }
}
