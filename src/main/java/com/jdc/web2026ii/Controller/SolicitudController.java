package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.SolicitudEntity;
import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.services.SolicitudService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/solicitudes/nueva")
    public String mostrarFormulario(
            Model model,
            HttpSession session) {

        UsuarioEntity usuario =
                (UsuarioEntity) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "solicitud",
                new SolicitudEntity()
        );

        model.addAttribute(
                "usuario",
                usuario
        );

        return "crear-solicitud";
    }

    @PostMapping("/solicitudes/guardar")
    public String guardarSolicitud(
            SolicitudEntity solicitud,
            HttpSession session) {

        UsuarioEntity usuario =
                (UsuarioEntity) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        solicitud.setUsuario(usuario);

        solicitudService.guardar(solicitud);

        return "redirect:/solicitudes/mis-solicitudes";
    }

    @GetMapping("/solicitudes/mis-solicitudes")
    public String misSolicitudes(
            Model model,
            HttpSession session) {

        UsuarioEntity usuario =
                (UsuarioEntity) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        List<SolicitudEntity> solicitudes =
                solicitudService.listarPorUsuario(usuario);

        model.addAttribute(
                "solicitudes",
                solicitudes
        );

        model.addAttribute(
                "usuario",
                usuario
        );

        return "mis-solicitudes";
    }
}