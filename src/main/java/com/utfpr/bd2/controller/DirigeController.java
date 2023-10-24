package com.utfpr.bd2.controller;

import com.utfpr.bd2.entity.Dirige;
import com.utfpr.bd2.service.DirigeService;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/dirige")
public class DirigeController {

    private final DirigeService service;

    public DirigeController(DirigeService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    List<Dirige> list() {
        return service.listar();
    }

    @GetMapping("/listarAsc")
    List<Dirige> listAsc() {
        return service.listarASC();
    }

    @DeleteMapping("/deletar/{id}")
    void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
