package io.github.geancarloslc.domain.repository;

import io.github.geancarloslc.domain.entity.MetaGasto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MetaGastoRepository extends JpaRepository<MetaGasto, Long> {

    @Query("SELECT m FROM MetaGasto m WHERE m.recursosUsuario.id = :recursosUsuarioId")
    Page<MetaGasto> buscarTodasMetas(@Param("recursosUsuarioId") Long recursosUsuarioId, Pageable pageable);

}
