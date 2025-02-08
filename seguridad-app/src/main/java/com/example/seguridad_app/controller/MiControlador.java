package com.example.seguridad_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MiControlador {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/publico")
    public String publico(@RequestParam(name = "lang", required = false) String lang) {
        Locale locale = (lang != null) ? new Locale(lang) : Locale.getDefault();
        return messageSource.getMessage("publico.mensaje", null, locale);
    }

    @GetMapping("/privado")
    public String privado(@RequestParam(name = "lang", required = false) String lang) {
        Locale locale = (lang != null) ? new Locale(lang) : Locale.getDefault();
        return messageSource.getMessage("privado.mensaje", null, locale);
    }
}
