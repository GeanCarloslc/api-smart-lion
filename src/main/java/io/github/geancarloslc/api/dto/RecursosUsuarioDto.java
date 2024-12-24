package io.github.geancarloslc.api.dto;

import io.github.geancarloslc.domain.entity.RecursosUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursosUsuarioDto {
    private Long id;
    private BigDecimal renda;
    private LocalDateTime data;
    private UsuarioDto usuarioDto;

    public RecursosUsuarioDto(String data) {
        this.data = data != null ? LocalDateTime.parse(data) : null;
    }

    public Page<RecursosUsuarioDto> toPageObjectDto(Page<RecursosUsuario> recursosUsuario) {
        return recursosUsuario.map(this::converterParaRecursosUsuarioDto);
    }

    private RecursosUsuarioDto converterParaRecursosUsuarioDto(RecursosUsuario recursosUsuario) {
        RecursosUsuarioDto recursosUsuarioDto = new RecursosUsuarioDto();
        recursosUsuarioDto.setId(recursosUsuario.getId());
        recursosUsuarioDto.setData(recursosUsuario.getData());
        recursosUsuarioDto.setRenda(recursosUsuario.getRenda());

        recursosUsuarioDto.setUsuarioDto(recursosUsuario.getUsuario().toDto());
        //conversion here
        return recursosUsuarioDto;
    }
}
