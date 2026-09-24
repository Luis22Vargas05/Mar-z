package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.UniversidadEntity;

import java.util.List;

public interface UniversidadService {

    public List<UniversidadEntity> findAll();

    public UniversidadEntity findById(Long id);

    public void save(UniversidadEntity universidad);

    public void delete(Long id);

    public void updateState(Long id);

    public List<UniversidadEntity> consultarUniversidades();

    List<UniversidadEntity> findUniversidadesActivas();

}
