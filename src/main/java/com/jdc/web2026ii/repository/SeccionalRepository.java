package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.SeccionalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeccionalRepository extends CrudRepository<SeccionalEntity, Integer> {

    @Query("SELECT s FROM SeccionalEntity s WHERE s.idseccional >= 6")
    public List<SeccionalEntity> consultarSeccionales();

}
