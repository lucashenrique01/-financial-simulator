package com.poc.insurance.services;

import com.poc.insurance.models.*;
import com.poc.insurance.repositorys.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEvents(){
        List<Event> events = eventRepository.findAll();
        return events;
    }

}
