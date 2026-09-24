package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.TelefonoEntity;

import java.util.List;

public interface TelefonoService {

    public List<TelefonoEntity> consultarPrimeros8();

    public List<TelefonoEntity> findAll();

    public TelefonoEntity findById(Integer id);

    public void save(TelefonoEntity telefono);

    public void delete(Integer id);
}
