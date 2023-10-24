package com.utfpr.bd2.controller;


import com.utfpr.bd2.entity.Motorista;

import com.utfpr.bd2.service.MotoristaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/motorista")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }


    @GetMapping("/listar")
    List<Motorista> list() {
        return service.listar();
    }

    @GetMapping("/listarAsc")
    List<Motorista> listAsc() {
        return service.listarASC();
    }

    @DeleteMapping("/deletar/{id}")
    void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
