package com.utfpr.bd2.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_dirige")
public class Dirige {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "data")
    private LocalDate Data;

    @Column(name = "hora")
    private Time hora;


    @ManyToOne
    @JoinColumn(name = "id_motorista",nullable = false)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "id_veiculo",nullable = false)
    private Veiculo veiculo;

    public Dirige() {
    }

    public Dirige(Long id, LocalDate data, Time hora, Motorista motorista, Veiculo veiculo) {
        this.id = id;
        Data = data;
        this.hora = hora;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }
    public Dirige( LocalDate data, Time hora, Motorista motorista, Veiculo veiculo) {

        Data = data;
        this.hora = hora;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }
    public Dirige( Motorista motorista, Veiculo veiculo) {

        Data = LocalDate.now();
        this.hora = Time.valueOf(LocalTime.now());
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Dirige{" +
                "id=" + id +
                ", Data=" + Data +
                ", hora=" + hora +
                ", motorista=" + motorista +
                ", veiculo=" + veiculo +
                '}';
    }
}
