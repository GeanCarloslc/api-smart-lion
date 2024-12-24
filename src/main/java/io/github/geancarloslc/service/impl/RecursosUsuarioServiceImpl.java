package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.RecursosUsuarioDto;
import io.github.geancarloslc.domain.entity.RecursosUsuario;
import io.github.geancarloslc.domain.entity.Usuario;
import io.github.geancarloslc.domain.repository.RecursoUsuarioRepository;
import io.github.geancarloslc.exception.ResourceNotFoundException;
import io.github.geancarloslc.service.RecursosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecursosUsuarioServiceImpl implements RecursosUsuarioService {

    @Autowired
    private RecursoUsuarioRepository recursoUsuarioRepository;

    @Override
    public Page<RecursosUsuarioDto> buscarTodos(Pageable pageable) {
        RecursosUsuario recursosUsuario = new RecursosUsuario();
        recursosUsuario.setUsuario(new Usuario(1L));
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        //ExampleMatcher.StringMatcher.CONTAINING, similar ao like do SQL
        Example<RecursosUsuario> exampleRecursosUsuario = Example.of(recursosUsuario, exampleMatcher);
        Page<RecursosUsuario> recursosUsuarioPage = recursoUsuarioRepository.findAll(exampleRecursosUsuario, pageable);

        if (recursosUsuarioPage.isEmpty()) {
            return new PageImpl<>(new ArrayList<>());
        }

        return new RecursosUsuarioDto().toPageObjectDto(recursosUsuarioPage);
    }

    @Override
    @Transactional
    public void salvar(RecursosUsuarioDto recursosUsuarioDto) {
        RecursosUsuario recursosUsuario = new RecursosUsuario(
                recursosUsuarioDto.getUsuarioDto().getId(),
                recursosUsuarioDto.getData(),
                recursosUsuarioDto.getRenda());

        recursoUsuarioRepository.save(recursosUsuario);
    }

    @Override
    @Transactional
    public void excluir(List<Long> ids) {
        recursoUsuarioRepository.deleteAllById(ids);
    }

    @Override
    @Transactional
    public void atualizar(Long id, RecursosUsuarioDto recursoUsuarioDto) {
        RecursosUsuario recursosUsuario = recursoUsuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso do usuario não encontrado com ID: " + id));

        recursosUsuario.setRenda(recursoUsuarioDto.getRenda());
        recursosUsuario.setData(recursoUsuarioDto.getData());
        recursosUsuario.editado();

        recursoUsuarioRepository.save(recursosUsuario);
    }
}
