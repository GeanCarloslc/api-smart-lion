package io.github.geancarloslc.api.dto;

import io.github.geancarloslc.domain.entity.MetaGasto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaGastoDto {

    private Long id;
    private CategoriaGastoDto categoriaGastoDto;
    private Long recursosUsuarioId;
    private BigDecimal valorMeta;


    public Page<MetaGastoDto> toPageObjectDto(Page<MetaGasto> metaGastoPage) {
        return metaGastoPage.map(this::converterParaMetaDto);
    }

    private MetaGastoDto converterParaMetaDto(MetaGasto metaGasto) {
        MetaGastoDto metaGastoDto = new MetaGastoDto();
        metaGastoDto.setId(metaGasto.getId());
        metaGastoDto.setCategoriaGastoDto(metaGasto.getCategoriaGasto().toDto());
        metaGastoDto.setValorMeta(metaGasto.getValorMeta());
        metaGastoDto.setRecursosUsuarioId(metaGasto.getRecursosUsuario().getId());

        return metaGastoDto;
    }
}
