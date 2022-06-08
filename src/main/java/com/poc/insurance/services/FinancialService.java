package com.poc.insurance.services;

import com.poc.insurance.models.Client;
import com.poc.insurance.models.Contract;
import com.poc.insurance.models.Data;
import com.poc.insurance.models.Financial;
import com.poc.insurance.repositorys.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static com.poc.insurance.models.PocType.NOTIFICATION;

@Component
public class FinancialService {

    @Autowired
    FinancialRepository financialRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ContractService contractService;

    public void persistClientAndContract(Contract contrato, Client cliente){
        clientService.persist(cliente);
        contractService.persist(contrato);
    }

    public HashMap newFinancial(Client client, Contract contract){
        client.setClientId(UUID.randomUUID().toString());
        client.setNomeCliente("nome-cliente");
        client.setDocumentoIdentificacao("doc-identificação-client");
        contract.setContratoId(UUID.randomUUID().toString());
        contract.setValorContratado(15_000.00);
        contract.setValorDoBem(50_000.00);
        persistClientAndContract(contract, client);
        Financial newFinancial = new Financial();
        newFinancial.setContract(contract);
        newFinancial.setClient(client);
        financialRepository.save(newFinancial);
        Data data  = new Data(NOTIFICATION, client, contract);
        HashMap<String, Object> mapData = new HashMap<>();
        mapData.put("PocType", data.getPocType());
        mapData.put("idCliente", data.getCliente().getClientId());
        mapData.put("idContrato", data.getContrato().getContratoId());
        return mapData;
    }

    public void persistFinancial(Financial financial){
        financialRepository.save(financial);
    }

    public List<Financial> getFinancials(){
        return financialRepository.findAll();
    }


    public Financial findByIdClienteAndIdContrato(String idClient, String idContract) {
        return financialRepository.findByClientIdAndContractId(clientService.findClient(idClient),
                contractService.findContract(idContract));
    }


}
