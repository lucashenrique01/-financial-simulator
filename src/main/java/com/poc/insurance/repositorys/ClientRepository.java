package com.poc.insurance.repositorys;

import com.poc.insurance.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findAll();

    Client findByIdClient(String idClient);
}
