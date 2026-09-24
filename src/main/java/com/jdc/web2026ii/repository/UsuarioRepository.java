package com.jdc.web2026ii.repository;

import com.jdc.web2026ii.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByCorreo(String correo);

    @Query(value = """
            SELECT *
            FROM usuarios
            WHERE correo = :correo
            AND contrasena = crypt(:contrasena, contrasena)
            """, nativeQuery = true)
    Optional<UsuarioEntity> validarCredenciales(
            @Param("correo") String correo,
            @Param("contrasena") String contrasena
    );
}