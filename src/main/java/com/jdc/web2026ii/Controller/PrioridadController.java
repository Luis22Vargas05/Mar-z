package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.services.SolicitudService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrioridadController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/coordinador/solicitudes/prioridad")
    public String actualizarPrioridad(
            @RequestParam Integer idsolicitud,
            @RequestParam String prioridad,
            HttpSession session) {

        UsuarioEntity usuario =
                (UsuarioEntity) session.getAttribute("usuario");

        // Si no ha iniciado sesión
        if (usuario == null) {
            return "redirect:/login";
        }

        // Solo el coordinador puede cambiar la prioridad
        if (!"COORDINADOR".equalsIgnoreCase(usuario.getRol())) {
            return "redirect:/solicitudes/mis-solicitudes";
        }

        solicitudService.actualizarPrioridad(
                idsolicitud,
                prioridad
        );

        return "redirect:/coordinador/solicitudes";
    }
}