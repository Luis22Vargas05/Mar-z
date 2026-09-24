package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<UsuarioEntity> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Optional<UsuarioEntity> validarCredenciales(
            String correo,
            String contrasena) {

        return usuarioRepository.validarCredenciales(
                correo,
                contrasena
        );
    }
}