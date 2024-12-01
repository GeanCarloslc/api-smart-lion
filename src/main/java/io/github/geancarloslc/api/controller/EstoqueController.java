package io.github.geancarloslc.api.controller;

import io.github.geancarloslc.api.dto.EstoqueDTO;
import io.github.geancarloslc.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping("/buscar-todos-itens-estoque")
    public Page<EstoqueDTO> buscarTodosItensEstoque(
            @RequestParam (required = false) String descricao,
            Pageable pageable
    ){
        EstoqueDTO filtroEstoqueDTO = new EstoqueDTO();
        filtroEstoqueDTO.setPageable(pageable);
        return estoqueService.buscarTodosItensEstoque(filtroEstoqueDTO);
    }
}
