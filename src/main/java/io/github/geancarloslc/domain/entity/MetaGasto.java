package io.github.geancarloslc.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "meta_gasto")
public class MetaGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaGasto categoria;

    @Column(name = "valor_meta", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMeta;

    @ManyToOne
    @JoinColumn(name = "recursos_usuario_id", nullable = false)
    private RecursosUsuario recursosUsuario;

}
