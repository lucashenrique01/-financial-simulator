package com.poc.insurance.models;

import javax.persistence.*;

@Entity
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Contract contract;
    @ManyToOne
    private Client client;

    public Financial(Contract contract, Client client) {
        this.contract = contract;
        this.client = client;
    }

    public Financial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
