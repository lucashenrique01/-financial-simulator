package com.poc.insurance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idCliente;
    private String nomeCliente;
    private String documentoIdentificacao;

    public Client(String idCliente, String nomeCliente, String documentoIdentificacao) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }
}
