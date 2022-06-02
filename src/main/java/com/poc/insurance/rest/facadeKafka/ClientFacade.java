package com.poc.insurance.rest.facadeKafka;

import com.poc.insurance.models.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "facade", url = "localhost:80/events")
public interface ClientFacade {

    @PostMapping
    void postEvent(@RequestBody Event event);

    @GetMapping
    List<Event> get();
}
