package com.utfpr.bd2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_motorista")
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "telefone")
    private String telefone;


    @OneToMany(mappedBy = "motorista", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @Nullable
    @JsonIgnore
    private List<Dirige> dirige;

    public Motorista() {
    }

    public Motorista(String nome, String sexo, String telefone) {

        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;

    }
    public Motorista(String nome, String sexo, String telefone, List<Dirige> dirige) {

        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dirige = dirige;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Dirige> getDirige() {
        return dirige;
    }

    public void setDirige(List<Dirige> dirige) {
        this.dirige = dirige;
    }

    @Override
    public String toString() {

        return "Motorista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
