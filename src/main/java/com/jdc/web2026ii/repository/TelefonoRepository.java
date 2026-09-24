package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.TelefonoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelefonoRepository extends CrudRepository<TelefonoEntity, Integer> {

    @Query(value = "SELECT * FROM telefonos LIMIT 8", nativeQuery = true)
    public List<TelefonoEntity> consultarPrimeros8();


}
