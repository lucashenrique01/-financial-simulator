package com.poc.insurance.repositorys;

import com.poc.insurance.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findAll();
}
