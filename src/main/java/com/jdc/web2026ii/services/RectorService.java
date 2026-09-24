package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.RectorEntity;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface RectorService {

    public void  save(RectorEntity rector);

    public List<RectorEntity> findAll();

    public RectorEntity findById(Integer id);

    public void delete(Integer id);

    public List<RectorEntity> consultarRectoresTipo1();

    RectorEntity findByUniversidad(Integer iduniversidad);

}