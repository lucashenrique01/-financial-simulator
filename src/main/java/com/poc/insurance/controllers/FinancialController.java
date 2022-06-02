package com.poc.insurance.controllers;

import com.poc.insurance.models.Financial;
import com.poc.insurance.services.EventService;
import com.poc.insurance.services.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    FinancialService financialService;

    @Autowired
    EventService eventService;

    @PostMapping
    ResponseEntity postFinancial(@RequestBody Financial financial){
        financialService.persistFinancial(financial);
        //eventService.persistEvent();
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/clients")
    ResponseEntity getClients(){
        return ResponseEntity.status(200).body(financialService.getClients());
    }

    @GetMapping("/contracts")
    ResponseEntity getContracts(){
        return ResponseEntity.status(200).body(financialService.getContracts());
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
