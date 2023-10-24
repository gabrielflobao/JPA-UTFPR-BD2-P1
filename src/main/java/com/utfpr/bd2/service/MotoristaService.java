package com.utfpr.bd2.service;

import com.utfpr.bd2.entity.Motorista;
import com.utfpr.bd2.repository.MotoristaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {
    private final MotoristaRepository repo;

    public MotoristaService(MotoristaRepository repo) {
        this.repo = repo;
    }


    public void salvar(Motorista motorista) {
        repo.save(motorista);
    }

    public List<Motorista> listar() {
        return this.repo.findAll();
    }

    public List<Motorista> listarASC() {
        return this.repo.findAll(Sort.by(Sort.Direction.ASC,"nome"));
    }

    public long countEntity() {
        return this.repo.count();
    }
    public void deleteById(Long id) {
        this.repo.deleteById(id);

    }
    public Motorista getReferenceById(Long id){
        return this.repo.getReferenceById(id);
    }
}
