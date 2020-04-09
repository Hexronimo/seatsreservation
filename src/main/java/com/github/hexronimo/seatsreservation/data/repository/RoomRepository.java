package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.SimpleRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<SimpleRoom, Long> {
    SimpleRoom findByName (String name);
}
