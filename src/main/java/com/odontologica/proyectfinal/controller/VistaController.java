package com.odontologica.proyectfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class VistaController {

    @GetMapping
    public String renderVista() {
        return "index";
    }
}
