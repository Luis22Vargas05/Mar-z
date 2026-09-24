package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.SolicitudEntity;
import com.jdc.web2026ii.entity.UsuarioEntity;

import java.util.List;

public interface SolicitudService {

    SolicitudEntity guardar(SolicitudEntity solicitud);

    Iterable<SolicitudEntity> listar();

    List<SolicitudEntity> listarPorUsuario(UsuarioEntity usuario);

    SolicitudEntity actualizarPrioridad(
            Integer idsolicitud,
            String prioridad
    );
}