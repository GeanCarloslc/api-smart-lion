package io.github.geancarloslc.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recursos_usuario")
public class RecursosUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "renda", nullable = false, precision = 10, scale = 2)
    private BigDecimal renda;

    @OneToMany(mappedBy = "recursosUsuario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Gasto> gastos;


    public RecursosUsuario(Long id, Long usuarioId, LocalDateTime data, BigDecimal renda) {
        if (id != null) {
            this.id = id;
        }
        this.usuario = new Usuario(usuarioId);
        this.data = data;
        this.renda = renda;
    }
}
