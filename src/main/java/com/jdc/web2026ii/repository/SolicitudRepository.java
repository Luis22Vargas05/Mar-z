package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.SolicitudEntity;
import com.jdc.web2026ii.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends CrudRepository<SolicitudEntity, Integer> {

    List<SolicitudEntity> findByUsuario(UsuarioEntity usuario);
}