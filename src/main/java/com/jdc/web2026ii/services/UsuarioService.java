package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioService {

    Optional<UsuarioEntity> buscarPorCorreo(String correo);

    Optional<UsuarioEntity> validarCredenciales(
            String correo,
            String contrasena
    );
}