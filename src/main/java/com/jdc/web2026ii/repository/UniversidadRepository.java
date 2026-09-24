package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.UniversidadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UniversidadRepository extends CrudRepository<UniversidadEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE UniversidadEntity SET estado = NOT estado WHERE iduniversidad = ?1")
    public void updateEstado(Long id);

    @Query("SELECT u FROM UniversidadEntity u WHERE u.nombre LIKE 'U%'")
    public List<UniversidadEntity> consultarUniversidades();

    @Query("SELECT u FROM UniversidadEntity u WHERE u.estado = true")
    List<UniversidadEntity> findUniversidadesActivas();

}