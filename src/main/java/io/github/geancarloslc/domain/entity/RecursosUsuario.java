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

    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;


    public RecursosUsuario(Long usuarioId, LocalDateTime data, BigDecimal renda) {
        this.usuario = new Usuario(usuarioId);
        this.data = data;
        this.renda = renda;
        this.dataInclusao = LocalDateTime.now();
    }

    public RecursosUsuario(Long id) {
        this.id = id;
    }

    public void editado(){
        this.dataEdicao = LocalDateTime.now();
    }
}
