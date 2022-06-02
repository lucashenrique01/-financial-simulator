package com.poc.insurance.repositorys;

import com.poc.insurance.models.Client;
import com.poc.insurance.models.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Integer> {

    List<Contract> findAll();

    Contract findByIdContrato(String idClient);
}
