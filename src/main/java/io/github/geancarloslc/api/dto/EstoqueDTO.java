package io.github.geancarloslc.api.dto;

import io.github.geancarloslc.domain.entity.Estoque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstoqueDTO {
    private Long id;
    private String descricao;
    private Long quantidade;
    private LocalDate dataCadastro;
    private LocalDate dataVencimento;
    private BigDecimal valorUnitario;
    private BigDecimal valorUnitarioEstimadoVenda;
    private Pageable pageable;

    public EstoqueDTO(String descricao) {
        this.descricao = descricao;
    }

    public Page<EstoqueDTO> toPageObjectDto(Page<Estoque> estoque) {
        Page<EstoqueDTO> dtos  = estoque.map(this::converterParaEstoqueDTO);
        return dtos;
    }

    private EstoqueDTO converterParaEstoqueDTO(Estoque o) {
        EstoqueDTO dto = new EstoqueDTO();
        dto.setId(o.getId());
        dto.setDescricao(o.getDescricao());
        //conversion here
        return dto;
    }
}
