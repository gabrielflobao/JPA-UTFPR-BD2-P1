package com.utfpr.bd2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;



    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnore
    @Nullable
    private List<Dirige> dirige;

    public Veiculo() {

    }

    public Veiculo(Long id, String modelo, String marca, List<Dirige> dirige) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.dirige = dirige;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Dirige> getDirige() {
        return dirige;
    }

    public void setDirige(List<Dirige> dirige) {
        this.dirige = dirige;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
