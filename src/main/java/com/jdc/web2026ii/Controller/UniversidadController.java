package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.entity.UniversidadEntity;
import com.jdc.web2026ii.services.UniversidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class UniversidadController {

    @Autowired
    private UniversidadService universidadService;

    @GetMapping("listarUniversidades")
    public String listarUniversidades(Model model) {
        model.addAttribute("universidades", universidadService.findAll());
        return "listarUniversidad";
    }

    @GetMapping("crearUniversidades")
    public String crearUniversidades(Model model) {
        model.addAttribute("objuniversidad", new UniversidadEntity());
        return "CrearUniversidad";
    }

    @PostMapping(value = "/crearUniversidad")
    public String guardarUniversidad(@Valid UniversidadEntity universidad, SessionStatus status) {
        universidad.setEstado(true);
        universidadService.save(universidad);
        status.setComplete();
        return "redirect:/listarUniversidades";
    }

    @RequestMapping("/eliminarUniversidadBy/{id}")
    public String elimminarById(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            universidadService.delete(id);
        }
        return "redirect:/listarUniversidades";
    }
    @GetMapping("/editarUniversidadBy/{id}")
    public String editarUniversidad(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("titulo","Actualizar Universidad");
        model.addAttribute("universidadActualizar", universidadService.findById(id));
        return "editarUniversidad";
    }
    @PostMapping("/editarUniversidadBy/{id}")
    public String guardarEditaUniversidad(@PathVariable(value = "id")Long id,
                                          @ModelAttribute("universidadActualizar")
                                          UniversidadEntity universidad){
        UniversidadEntity universidadExistente = universidadService.findById(id);
        universidadExistente.setNombre(universidad.getNombre());
        universidadExistente.setNit(universidad.getNit());
        universidadExistente.setDescripcion(universidad.getDescripcion());
        universidad.setEstado(true);

        universidadService.save(universidadExistente);
        return "redirect:/listarUniversidades";
    }
    @RequestMapping(value = "/cambiarEstado/{id}")
    public String cambiarEstadoById(@PathVariable(value="id")Long id){
        if (id>0){
            universidadService.updateState(id);
        }
        return "redirect:/listarUniversidades";
    }
}