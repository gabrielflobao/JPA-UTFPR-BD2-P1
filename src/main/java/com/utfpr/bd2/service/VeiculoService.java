package com.utfpr.bd2.service;

import com.utfpr.bd2.entity.Veiculo;
import com.utfpr.bd2.repository.VeiculoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repo;

    public VeiculoService(VeiculoRepository repo) {
        this.repo = repo;
    }

    public void salvar(Veiculo motorista) {
        repo.save(motorista);
    }

    public List<Veiculo> listar() {
        return this.repo.findAll();
    }

    public List<Veiculo> listarASC() {
        return this.repo.findAll(Sort.by(Sort.Direction.ASC,"marca"));
    }

    public long countEntity() {
        return this.repo.count();
    }
    public void deleteById(Long id) {
        this.repo.deleteById(id);

    }
    public Veiculo getReferenceById(Long id){
        return this.repo.getReferenceById(id);
    }
}

