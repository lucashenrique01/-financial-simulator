package com.poc.insurance.models;

public enum PocType {
    NOTIFICATION("Event notification"),
    CARRIED_STATE_TRANSFER("Event carried state transfer");

    String descricao;

    PocType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
