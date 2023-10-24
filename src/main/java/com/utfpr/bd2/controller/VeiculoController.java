package com.utfpr.bd2.controller;

import com.utfpr.bd2.entity.Veiculo;
import com.utfpr.bd2.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    List<Veiculo> list() {
        return service.listar();
    }

    @GetMapping("/listarAsc")
    List<Veiculo> listAsc() {
        return service.listarASC();
    }

    @DeleteMapping("/deletar/{id}")
    void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
