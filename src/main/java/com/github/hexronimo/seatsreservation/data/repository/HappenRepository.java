package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.EventHappen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HappenRepository extends CrudRepository<EventHappen, Long> {

    List<EventHappen> findAllByDateStartBetweenOrderByDateStartAscTimeStartAsc(LocalDate from, LocalDate to);
}
