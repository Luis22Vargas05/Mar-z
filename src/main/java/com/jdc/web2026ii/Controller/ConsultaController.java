package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.services.RectorService;
import com.jdc.web2026ii.services.SeccionalService;
import com.jdc.web2026ii.services.TelefonoService;
import com.jdc.web2026ii.services.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaController {

    @Autowired
    private RectorService rectorService;

    @Autowired
    private SeccionalService seccionalService;

    @Autowired
    private UniversidadService universidadService;

    @Autowired
    private TelefonoService telefonoService;


    // CONSULTA 1
    @GetMapping("/consulta1")
    public String consulta1(Model model) {

        model.addAttribute("rectores",
                rectorService.consultarRectoresTipo1());

        return "consulta1";
    }


    // CONSULTA 2
    @GetMapping("/consulta2")
    public String consulta2(Model model) {

        model.addAttribute("seccionales",
                seccionalService.consultarSeccionales());

        return "consulta2";
    }


    // CONSULTA 3
    @GetMapping("/consulta3")
    public String consulta3(Model model) {

        model.addAttribute("universidades",
                universidadService.consultarUniversidades());

        return "consulta3";
    }


    // CONSULTA 4
    @GetMapping("/consulta4")
    public String consulta4(Model model) {

        model.addAttribute("telefonos",
                telefonoService.consultarPrimeros8());

        return "consulta4";
    }

}