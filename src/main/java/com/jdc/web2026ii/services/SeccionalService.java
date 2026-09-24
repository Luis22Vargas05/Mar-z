
package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.SeccionalEntity;

import java.util.List;

public interface SeccionalService {

    public List<SeccionalEntity> findAll();

    public List<SeccionalEntity> consultarSeccionales();

    public SeccionalEntity findById(Integer id);

    public void save(SeccionalEntity seccional);

    public void delete(Integer id);
}