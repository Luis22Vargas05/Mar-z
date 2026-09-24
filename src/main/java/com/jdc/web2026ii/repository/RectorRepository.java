package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.RectorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RectorRepository extends CrudRepository<RectorEntity, Integer> {

    @Query("SELECT r FROM RectorEntity r WHERE r.tipo = 1")
    public List<RectorEntity> consultarRectoresTipo1();

    @Query("SELECT r FROM RectorEntity r WHERE r.universidad.iduniversidad = ?1")
    RectorEntity findByUniversidad(Integer  iduniversidad);
}