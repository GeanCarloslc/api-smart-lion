package io.github.geancarloslc.domain.repository;

import io.github.geancarloslc.domain.entity.RecursosUsuario;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecursoUsuarioRepository extends JpaRepository<RecursosUsuario, Long> {
    Optional<RecursosUsuario> findById(Long id);

    Page<RecursosUsuario> findAll(Example  example, Pageable pageable);

}
