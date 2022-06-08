package com.poc.insurance.services;

import com.poc.insurance.models.Client;
import com.poc.insurance.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public void persist(Client client){
        clientRepository.save(client);
    }

    public Integer findClient(String idClient) {
        return clientRepository.findByClientId(idClient).getId();
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
}
