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
public class RecursoUsuarioDto {
    private Long id;
    private BigDecimal renda;
    private LocalDateTime data;
    private UsuarioDto usuarioDto;

    public RecursoUsuarioDto(String data) {
        this.data = data != null ? LocalDateTime.parse(data) : null;
    }

    public Page<RecursoUsuarioDto> toPageObjectDto(Page<RecursosUsuario> recursosUsuario) {
        return recursosUsuario.map(this::converterParaRecursosUsuarioDto);
    }

    private RecursoUsuarioDto converterParaRecursosUsuarioDto(RecursosUsuario recursosUsuario) {
        RecursoUsuarioDto recursoUsuarioDto = new RecursoUsuarioDto();
        recursoUsuarioDto.setId(recursosUsuario.getId());
        recursoUsuarioDto.setData(recursosUsuario.getData());
        recursoUsuarioDto.setRenda(recursosUsuario.getRenda());

        recursoUsuarioDto.setUsuarioDto(recursosUsuario.getUsuario().toDto());
        //conversion here
        return recursoUsuarioDto;
    }
}
