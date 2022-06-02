package com.poc.insurance.services;

import com.poc.insurance.models.Client;
import com.poc.insurance.models.Contract;
import com.poc.insurance.models.Financial;
import com.poc.insurance.repositorys.ClientRepository;
import com.poc.insurance.repositorys.ContractRepository;
import com.poc.insurance.repositorys.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinancialService {

    @Autowired
    FinancialRepository financialRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ContractRepository contractRepository;

    public void persistClientandContract(Contract contrato, Client cliente){
        clientRepository.save(cliente);
        contractRepository.save(contrato);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }


    public List<Contract> getContracts(){
        return contractRepository.findAll();
    }

    public void persistFinancial(Financial financial){

        financialRepository.save(financial);
    }

    public List<Financial> getFinancials(){
        return financialRepository.findAll();
    }


    public Integer findClient(String idClient) {
        return clientRepository.findByIdClient(idClient).getId();
    }


    public Integer findContract(String idContract) {
        return contractRepository.findByIdContrato(idContract).getId();
    }

    public Financial findByIdClienteAndIdContrato(String idClient, String idContract) {
        return financialRepository.findByClientIdAndContractId(idClient, idContract);
    }


}
