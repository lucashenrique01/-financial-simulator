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
    private String contratoId;
    private Double valorContratado;
    private Double valorDoBem;

    public Contract(String idContrato, Double valorContratado, Double valorDoBem) {
        this.contratoId = idContrato;
        this.valorContratado = valorContratado;
        this.valorDoBem = valorDoBem;
    }

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public String getContratoId() {
        return contratoId;
    }

    public void setContratoId(String contratoId) {
        this.contratoId = contratoId;
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
