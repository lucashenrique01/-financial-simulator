package com.poc.insurance.controllers;

import com.poc.insurance.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    ResponseEntity getClients(){
        return ResponseEntity.status(200).body(clientService.getClients());
    }
}
