package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.SeccionalEntity;
import com.jdc.web2026ii.services.SeccionalService;
import com.jdc.web2026ii.services.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SeccionalController {

    @Autowired
    private SeccionalService seccionalService;

    @Autowired
    private UniversidadService universidadService;

    @GetMapping("/listarSeccionales")
    public String listarSeccionales(Model model) {

        model.addAttribute("seccionales", seccionalService.findAll());

        return "listarSeccional";
    }

    @GetMapping("/crearSeccionales")
    public String crearSeccionales(Model model) {
        model.addAttribute("objseccional", new SeccionalEntity());
        model.addAttribute("universidades", universidadService.findAll());
        return "CrearSeccional";
    }

    @PostMapping("/crearSeccional")
    public String guardarSeccional(
            SeccionalEntity seccional,
            SessionStatus status) {
        seccionalService.save(seccional);
        status.setComplete();
        return "redirect:/listarSeccionales";
    }

    @RequestMapping("/eliminarSeccionalBy/{id}")
    public String eliminarById(
            @PathVariable(value = "id") Integer id) {
        if (id > 0) {
            seccionalService.delete(id);
        }
        return "redirect:/listarSeccionales";
    }

    @GetMapping("/editarSeccionalBy/{id}")
    public String editarSeccional(
            @PathVariable(value = "id") Integer id,
            Model model) {
        model.addAttribute("titulo", "Actualizar Seccional");
        model.addAttribute("seccionalActualizar", seccionalService.findById(id));
        model.addAttribute("universidades", universidadService.findAll());

        return "editarSeccional";
    }

    @PostMapping("/editarSeccionalBy/{id}")
    public String guardarEditaSeccional(
            @PathVariable(value = "id") Integer id,
            @ModelAttribute("seccionalActualizar")
            SeccionalEntity seccional) {
        SeccionalEntity seccionalExistente = seccionalService.findById(id);
        seccionalExistente.setNombre(seccional.getNombre());
        seccionalExistente.setDireccion(seccional.getDireccion());
        seccionalExistente.setUniversidad(seccional.getUniversidad());
        seccionalService.save(seccionalExistente);

        return "redirect:/listarSeccionales";
    }
}