package io.github.geancarloslc.domain.entity;

import io.github.geancarloslc.api.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    public UsuarioDto toDto() {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(this.id);
        usuarioDto.setNome(this.nome);
        usuarioDto.setEmail(this.email);
        usuarioDto.setSenha(this.senha);
        usuarioDto.setDataCriacao(this.dataCriacao);
        return usuarioDto;
    }

    public Usuario(Long id) {
        this.id = id;
    }
}
