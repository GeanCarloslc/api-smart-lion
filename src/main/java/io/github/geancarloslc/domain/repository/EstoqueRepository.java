package io.github.geancarloslc.domain.repository;

import io.github.geancarloslc.domain.entity.Estoque;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findById(Long id);

    Page<Estoque> findAll(Example  example, Pageable pageable);

}
