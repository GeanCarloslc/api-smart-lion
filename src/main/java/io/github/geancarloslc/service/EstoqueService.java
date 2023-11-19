package io.github.geancarloslc.service;
import io.github.geancarloslc.api.dto.EstoqueDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EstoqueService {
    Page<EstoqueDTO> buscarTodosItensEstoque(EstoqueDTO filtroEstoqueDTO);
}
