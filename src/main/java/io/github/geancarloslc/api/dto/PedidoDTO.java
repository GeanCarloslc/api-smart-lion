package io.github.geancarloslc.api.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

// Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão
// de projetos bastante usado em Java para o transporte de dados entre
// diferentes componentes de um sistema, diferentes instâncias ou processos
// de um sistema distribuído ou diferentes sistemas via serialização.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itensPedidos;
}
