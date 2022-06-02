package com.poc.insurance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idContrato;
    private Double valorContratado;
    private Double valorDoBem;

    public Contract(String idContrato, Double valorContratado, Double valorDoBem) {
        this.idContrato = idContrato;
        this.valorContratado = valorContratado;
        this.valorDoBem = valorDoBem;
    }

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public Double getValorContratado() {
        return valorContratado;
    }

    public void setValorContratado(Double valorContratado) {
        this.valorContratado = valorContratado;
    }

    public Double getValorDoBem() {
        return valorDoBem;
    }

    public void setValorDoBem(Double valorDoBem) {
        this.valorDoBem = valorDoBem;
    }
}
