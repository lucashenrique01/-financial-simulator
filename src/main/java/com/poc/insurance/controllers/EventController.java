package com.poc.insurance.controllers;

import com.poc.insurance.models.Event;
import com.poc.insurance.rest.facadeKafka.ClientFacade;
import com.poc.insurance.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private ClientFacade clientFacade;

    @Autowired
    private EventService eventService;

    @PostMapping("/api-events")
    void post(@RequestBody Event newEvent){
        clientFacade.postEvent(eventService.sendEventToBroker(newEvent));
    }


    @GetMapping("/api-events")
    ResponseEntity get(){
        List<Event> eventos = clientFacade.get();
        return ResponseEntity.status(200).body(eventos);
    }

}
