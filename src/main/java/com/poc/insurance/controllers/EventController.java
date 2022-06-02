package com.poc.insurance.controllers;

import com.poc.insurance.models.Event;
import com.poc.insurance.rest.facadeKafka.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private ClientFacade clientFacade;

    @PostMapping
    void post(@RequestBody Event event){
        clientFacade.postEvent(event);
    }

    @GetMapping
    ResponseEntity get(){
        List<Event> eventos = new ArrayList<>();
        eventos = clientFacade.get();
        return ResponseEntity.status(200).body(eventos);
    }
}
