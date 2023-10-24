package com.utfpr.bd2.service;

import com.utfpr.bd2.entity.Dirige;
import com.utfpr.bd2.repository.DirigeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DirigeService {
    private final DirigeRepository repo;

    public DirigeService(DirigeRepository repo) {
        this.repo = repo;
    }


    public void salvar(Dirige Dirige) {
        repo.save(Dirige);
    }

    public List<Dirige> listar() {
        return this.repo.findAll();
    }

    public List<Dirige> listarASC() {
        return this.repo.findAll(Sort.by(Sort.Direction.ASC,"nome"));
    }

    public long countEntity() {
        return this.repo.count();
    }
    public void deleteById(Long id) {
        this.repo.deleteById(id);

    }
    public List<Dirige> findByPeriod(LocalDate d1 , LocalDate d2) {
      return   this.repo.findByPeriod(d1,d2);

    }
    public Dirige getReferenceById(Long id){
        return this.repo.getReferenceById(id);
    }
}
