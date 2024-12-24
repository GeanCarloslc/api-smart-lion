package io.github.geancarloslc.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meta_gasto")
public class MetaGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaGasto categoriaGasto;

    @Column(name = "valor_meta", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMeta;

    @ManyToOne
    @JoinColumn(name = "recursos_usuario_id", nullable = false)
    private RecursosUsuario recursosUsuario;

    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;


    public MetaGasto(Long categoriaId, BigDecimal valorMeta, Long recursosUsuarioId) {
        this.categoriaGasto = new CategoriaGasto(categoriaId);
        this.valorMeta = valorMeta;
        this.recursosUsuario = new RecursosUsuario(recursosUsuarioId);
        this.dataInclusao = LocalDateTime.now();
    }

    public void editado(){
        this.dataEdicao = LocalDateTime.now();
    }

}
