package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findReservationsByEventHappen_Id(Long id);
    Integer countAllByEventHappen_Id(Long id);
}
