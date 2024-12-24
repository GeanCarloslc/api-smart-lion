package io.github.geancarloslc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaGastoDto {
    private Long id;
    private String nome;
    private String icone;
}
