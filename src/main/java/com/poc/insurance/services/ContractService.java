package com.poc.insurance.services;

import com.poc.insurance.models.Client;
import com.poc.insurance.models.Contract;
import com.poc.insurance.models.Financial;
import com.poc.insurance.repositorys.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    public void persist(Contract contract){
        contractRepository.save(contract);
    }

    public List<Contract> getContracts(){
        return contractRepository.findAll();
    }

    public Integer findContract(String idContract) {
        return contractRepository.findByContratoId(idContract).getId();
    }

}
