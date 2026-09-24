package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.RectorEntity;
import com.jdc.web2026ii.entity.UniversidadEntity;
import com.jdc.web2026ii.services.RectorService;
import com.jdc.web2026ii.services.UniversidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class RectorController {

    @Autowired
    private RectorService rectorService;
    @Autowired
    private UniversidadService universidadService;

    @GetMapping("listarRectores")
    public String listarRectores(Model model){
        model.addAttribute("rectores", rectorService.findAll());
        return "listarRector";
    }

    @GetMapping("crearRectores")
    public String crearRectores(Model model){
        model.addAttribute("objrector", new RectorEntity());
        model.addAttribute("universidades", universidadService.findAll());
        model.addAttribute("universidades", universidadService.findUniversidadesActivas());
        return "crearRector";
    }

    @PostMapping(value = "/crearRector")
    public String guardarRector(
            RectorEntity rector,
            SessionStatus status) {
        rectorService.save(rector);
        status.setComplete();
        return "redirect:/listarRectores";
    }
    @RequestMapping("/eliminarRectorBy/{id}")
    public String eliminarById(@PathVariable(value = "id") int id) {
        if (id > 0){
            rectorService.delete(id);
        }
        return "redirect:/listarRectores";
    }
    @GetMapping("/editarRectorBy/{id}")
    public String editarRectorBy(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("rectorActualizar", rectorService.findById(id));
        model.addAttribute("universidades", universidadService.findAll());
        model.addAttribute("universidades", universidadService.findUniversidadesActivas());
        return "editarRector";
    }
    @PostMapping("/editarRectorBy/{id}")
    public String guardarEditRector(
            @PathVariable(value = "id") Integer id,
            @ModelAttribute("rectorActualizar") RectorEntity rector,
            Model model) {
        RectorEntity rectorExistente = rectorService.findById(id);
        RectorEntity rectorUniversidad = rectorService.findByUniversidad(
                        rector.getUniversidad().getIduniversidad()
                );
        if (rectorUniversidad != null &&
                !rectorUniversidad.getIdrector().equals(id)) {
            model.addAttribute("error",
                    "Esta universidad ya tiene un rector. Seleccione otra universidad.");
            model.addAttribute("rectorActualizar", rectorExistente);
            model.addAttribute("universidades", universidadService.findAll());
            return "editarRector";
        }
        rectorExistente.setNombre(rector.getNombre());
        rectorExistente.setFechadenacimiento(rector.getFechadenacimiento());
        rectorExistente.setNumdocumento(rector.getNumdocumento());
        rectorExistente.setPrimerapellido(rector.getPrimerapellido());
        rectorExistente.setSegundoapellido(rector.getSegundoapellido());
        rectorExistente.setUniversidad(rector.getUniversidad());
        rectorExistente.setTipo(rector.getTipo());
        rectorService.save(rectorExistente);

        return "redirect:/listarRectores";
    }
}
