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

@Service
public class RecursoUsuarioServiceImpl implements RecursoUsuarioService {

    @Autowired
    private RecursoUsuarioRepository recursoUsuarioRepository;

//    @Override
//    public Page<RecursoUsuarioRequest> buscarTodosItensEstoque(RecursoUsuarioRequest filtroRecursoUsuarioRequest) {
//        Estoque estoque = new Estoque();
//        //estoque.setDescricao(filtroEstoqueDTO.getDescricao());
//        Pageable pageable = PageRequest.of(0, 1);
//        ExampleMatcher exampleMatcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );
//        //ExampleMatcher.StringMatcher.CONTAINING, similar ao like do SQL
//        Example exampleEstoque = Example.of(estoque, exampleMatcher);
//        Page<Estoque> all = recursoUsuarioRepository.findAll(exampleEstoque, filtroRecursoUsuarioRequest.getPageable());
//        return converterEstoqueDTO(all);
//    }
//
//    private Page<RecursoUsuarioRequest> converterEstoqueDTO(Page<Estoque> estoqueList){
//        if(estoqueList.isEmpty()){
//            return new PageImpl<>(new ArrayList<RecursoUsuarioRequest>());
//        }
//        RecursoUsuarioRequest recursoUsuarioRequest = new RecursoUsuarioRequest();
//        Page<RecursoUsuarioRequest> pageObjectDto = recursoUsuarioRequest.toPageObjectDto(estoqueList);
//
//        return pageObjectDto;
//    }

    @Override
    public Page<RecursoUsuarioDto> buscarTodosRecursosUsuario(RecursoUsuarioDto filtroRecursoUsuarioRequest, Pageable pageable) {
        RecursosUsuario recursosUsuario = new RecursosUsuario();
        recursosUsuario.setUsuario(new Usuario(1L));
        recursosUsuario.setData(filtroRecursoUsuarioRequest.getData());
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        //ExampleMatcher.StringMatcher.CONTAINING, similar ao like do SQL
        Example<RecursosUsuario> exampleRecursosUsuario = Example.of(recursosUsuario, exampleMatcher);
        Page<RecursosUsuario> recursosUsuarioPage = recursoUsuarioRepository.findAll(exampleRecursosUsuario, pageable);

        return converteRecursoUsuarioPageDto(recursosUsuarioPage);
    }

    private Page<RecursoUsuarioDto> converteRecursoUsuarioPageDto(Page<RecursosUsuario> recursosUsuarioPage) {
        if (recursosUsuarioPage.isEmpty()) {
            return new PageImpl<>(new ArrayList<RecursoUsuarioDto>());
        }
        RecursoUsuarioDto recursoUsuarioDto = new RecursoUsuarioDto();
        return recursoUsuarioDto.toPageObjectDto(recursosUsuarioPage);
    }
}
