package io.github.geancarloslc.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;
}
