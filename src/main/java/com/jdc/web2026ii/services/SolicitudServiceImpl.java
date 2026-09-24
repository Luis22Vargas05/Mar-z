package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.SolicitudEntity;
import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public SolicitudEntity guardar(SolicitudEntity solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Iterable<SolicitudEntity> listar() {
        return solicitudRepository.findAll();
    }

    @Override
    public List<SolicitudEntity> listarPorUsuario(UsuarioEntity usuario) {
        return solicitudRepository.findByUsuario(usuario);
    }

    @Override
    public SolicitudEntity actualizarPrioridad(
            Integer idsolicitud,
            String prioridad) {

        SolicitudEntity solicitud =
                solicitudRepository.findById(idsolicitud)
                        .orElse(null);

        if (solicitud == null) {
            return null;
        }

        solicitud.setPrioridad(prioridad);

        return solicitudRepository.save(solicitud);
    }
}