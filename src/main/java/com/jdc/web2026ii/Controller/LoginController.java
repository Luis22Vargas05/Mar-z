package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.UsuarioEntity;
import com.jdc.web2026ii.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(
            @RequestParam String correo,
            @RequestParam String contrasena,
            Model model,
            HttpSession session) {

        UsuarioEntity usuario = usuarioService
                .validarCredenciales(correo, contrasena)
                .orElse(null);

        if (usuario == null) {

            model.addAttribute(
                    "error",
                    "Correo o contraseña incorrectos"
            );

            return "login";
        }

        // Guardamos el usuario que inició sesión
        session.setAttribute("usuario", usuario);

        // Redirección dependiendo del rol
        if ("SOLICITANTE".equalsIgnoreCase(usuario.getRol())) {

            return "redirect:/solicitudes/nueva";

        } else if ("COORDINADOR".equalsIgnoreCase(usuario.getRol())) {

            return "redirect:/coordinador/solicitudes";

        } else if ("AGENTE".equalsIgnoreCase(usuario.getRol())) {

            return "redirect:/agente/solicitudes";

        } else if ("AUDITOR".equalsIgnoreCase(usuario.getRol())) {

            return "redirect:/auditor/solicitudes";

        }

        // Si el usuario tiene un rol no reconocido
        model.addAttribute(
                "error",
                "El usuario no tiene un rol válido"
        );

        session.invalidate();

        return "login";
    }
}