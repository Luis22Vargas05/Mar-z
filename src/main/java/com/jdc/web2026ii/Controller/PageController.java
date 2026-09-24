package com.jdc.web2026ii.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("miweb")
    public String miweb() {
        return "HolaHTML";
    }

    @GetMapping("pensum")
    public String pensum() {
        return "pensum";
    }

    @GetMapping("acerca")
    public String acerca() {
        return "acerca";
    }
}