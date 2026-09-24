package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.SolicitudEntity;
import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.services.SolicitudService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoordinadorController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/coordinador/solicitudes")
    public String solicitudesCoordinador(
            Model model,
            HttpSession session) {

        UsuarioEntity usuario =
                (UsuarioEntity) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!"COORDINADOR".equalsIgnoreCase(usuario.getRol())) {
            return "redirect:/solicitudes/mis-solicitudes";
        }

        Iterable<SolicitudEntity> solicitudes =
                solicitudService.listar();

        model.addAttribute(
                "solicitudes",
                solicitudes
        );

        model.addAttribute(
                "usuario",
                usuario
        );

        return "coordinador-solicitudes";
    }
}