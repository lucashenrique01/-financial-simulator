package com.poc.insurance.controllers;

import com.poc.insurance.models.Event;
import com.poc.insurance.models.Financial;
import com.poc.insurance.rest.facadeKafka.ClientFacade;
import com.poc.insurance.services.ClientService;
import com.poc.insurance.services.ContractService;
import com.poc.insurance.services.EventService;
import com.poc.insurance.services.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    FinancialService financialService;

    @Autowired
    ClientFacade clientFacade;

    @Autowired
    ContractService contractService;

    @PostMapping
    ResponseEntity postFinancial(@RequestBody Financial financial){
        Event newEvent = new Event();
        newEvent.setId(UUID.randomUUID().toString());
        newEvent.setSpecVersion("1.0");
        newEvent.setSource("/product/domain/subdomain/service");
        newEvent.setType("br.com.example.correctTopic.Seg");
        newEvent.setTime("2022-06-07T17:41:02");
        newEvent.setSubject("Novo financiamento");
        newEvent.setCorrelationID("");
        newEvent.setDataContentType("application/json");
        try {
            newEvent.setData(financialService.newFinancial(financial.getClient(), financial.getContract()));
            clientFacade.postEvent(newEvent);
        } catch (Exception e){
            System.out.println("Erro: " +e);
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    ResponseEntity getFinancials(){
        return ResponseEntity.status(200).body(financialService.getFinancials());
    }


    @GetMapping("/{idCliente}/{idContrato}")
    ResponseEntity getFinancialByIdClienteAndIdContrato(@PathVariable String idCliente,
                                                        @PathVariable String idContrato){
        Financial financial = financialService.findByIdClienteAndIdContrato(idCliente, idContrato);
        if(Objects.isNull(financial)){
            return ResponseEntity.status(404).build();
        }
       return ResponseEntity.status(200).body(financial);
    }
}
