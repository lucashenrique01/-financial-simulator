package com.poc.insurance.models;


public class Data {
    private PocType pocType;
    private Client cliente;
    private Contract contrato;

    public Data(PocType pocType, Client cliente, Contract contrato) {
        this.pocType = pocType;
        this.cliente = cliente;
        this.contrato = contrato;
    }

    public String getPocType() {
        return pocType.getDescricao();
    }

    public void setPocType(PocType pocType) {
        this.pocType = pocType;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Contract getContrato() {
        return contrato;
    }

    public void setContrato(Contract contrato) {
        this.contrato = contrato;
    }
}
