package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName (String name);
}
