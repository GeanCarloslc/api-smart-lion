package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.EstoqueDTO;
import io.github.geancarloslc.domain.entity.Estoque;
import io.github.geancarloslc.domain.repository.EstoqueRepository;
import io.github.geancarloslc.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Page<EstoqueDTO> buscarTodosItensEstoque(EstoqueDTO filtroEstoqueDTO) {
        Estoque estoque = new Estoque();
        //estoque.setDescricao(filtroEstoqueDTO.getDescricao());
        Pageable pageable = PageRequest.of(0, 1);
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );
        //ExampleMatcher.StringMatcher.CONTAINING, similar ao like do SQL
        Example exampleEstoque = Example.of(estoque, exampleMatcher);
        Page<Estoque> all = estoqueRepository.findAll(exampleEstoque, filtroEstoqueDTO.getPageable());
        return converterEstoqueDTO(all);
    }

    private Page<EstoqueDTO> converterEstoqueDTO(Page<Estoque> estoqueList){
        if(estoqueList.isEmpty()){
            return new PageImpl<>(new ArrayList<EstoqueDTO>());
        }
        EstoqueDTO estoqueDTO = new EstoqueDTO();
        Page<EstoqueDTO> pageObjectDto = estoqueDTO.toPageObjectDto(estoqueList);

        return pageObjectDto;
    }
}
