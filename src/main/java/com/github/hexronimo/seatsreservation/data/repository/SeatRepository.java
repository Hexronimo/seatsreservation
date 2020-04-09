package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.SimpleRoom;
import com.github.hexronimo.seatsreservation.data.entity.SimpleSeat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository <SimpleSeat, Long>{
    List<SimpleSeat> findAllByRoom(SimpleRoom room);
    List<SimpleSeat> findAllByRoom_Id(Long id);
}
