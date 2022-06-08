package com.poc.insurance.controllers;

import com.poc.insurance.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping
    ResponseEntity getContracts(){
        return ResponseEntity.status(200).body(contractService.getContracts());
    }

}
