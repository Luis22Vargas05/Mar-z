package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.TelefonoEntity;
import com.jdc.web2026ii.services.SeccionalService;
import com.jdc.web2026ii.services.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;
    @Autowired
    private SeccionalService seccionalService;

    @GetMapping("/listarTelefonos")
    public String listarTelefonos(Model model) {
        model.addAttribute("telefonos", telefonoService.findAll());
        return "listarTelefono";
    }

    @GetMapping("/crearTelefonos")
    public String crearTelefonos(Model model) {
        model.addAttribute("objtelefono", new TelefonoEntity());
        model.addAttribute("seccionales",
                seccionalService.findAll());
        return "CrearTelefono";
    }
    @PostMapping("/crearTelefono")
    public String guardarTelefono(
            TelefonoEntity telefono,
            SessionStatus status) {
        telefonoService.save(telefono);
        status.setComplete();
        return "redirect:/listarTelefonos";
    }

    @RequestMapping("/eliminarTelefonoBy/{id}")
    public String eliminarById(
            @PathVariable(value = "id") Integer id) {
        if (id > 0) {
            telefonoService.delete(id);
        }
        return "redirect:/listarTelefonos";
    }

    @GetMapping("/editarTelefonoBy/{id}")
    public String editarTelefono(
            @PathVariable(value = "id") Integer id,
            Model model) {
        model.addAttribute("titulo", "Actualizar Teléfono");
        model.addAttribute("telefonoActualizar", telefonoService.findById(id));
        model.addAttribute("seccionales", seccionalService.findAll());
        return "editarTelefono";
    }

    @PostMapping("/editarTelefonoBy/{id}")
    public String guardarEditaTelefono(
            @PathVariable(value = "id") Integer id,
            @ModelAttribute("telefonoActualizar")
            TelefonoEntity telefono) {TelefonoEntity telefonoExistente =
            telefonoService.findById(id);telefonoExistente.setTipo(telefono.getTipo());
            telefonoExistente.setNumero(telefono.getNumero());
            telefonoExistente.setSeccional(telefono.getSeccional());
            telefonoService.save(telefonoExistente);

        return "redirect:/listarTelefonos";
    }
}