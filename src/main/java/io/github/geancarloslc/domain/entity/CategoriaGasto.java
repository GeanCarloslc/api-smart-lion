package io.github.geancarloslc.domain.entity;

import io.github.geancarloslc.api.dto.CategoriaGastoDto;
import io.github.geancarloslc.api.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria_gasto")
public class CategoriaGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "icone", nullable = false, length = 100)
    private String icone;

    public CategoriaGasto(Long id) {
        this.id = id;
    }

    public CategoriaGastoDto toDto() {
        return new CategoriaGastoDto(this.id, this.nome, this.icone);
    }

    public static List<CategoriaGastoDto> toDto(List<CategoriaGasto> categoriaGastoLista) {
        List<CategoriaGastoDto> categoriaGastoDtoLista = new ArrayList<>();

        categoriaGastoLista.forEach(categoriaGasto ->
                categoriaGastoDtoLista.add(new CategoriaGastoDto(categoriaGasto.getId(), categoriaGasto.getNome(), categoriaGasto.getIcone())));

        return categoriaGastoDtoLista;
    }
}
