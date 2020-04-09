package com.github.hexronimo.seatsreservation.business.service;

import com.github.hexronimo.seatsreservation.data.entity.*;
import com.github.hexronimo.seatsreservation.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ReservationService {

    private final SeatRepository seatRepository;
    private final RoomRepository roomRepository;
    private final EventRepository eventRepository;
    private final HappenRepository happenRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ReservationService(SeatRepository seatRepository,
                              RoomRepository roomRepository,
                              EventRepository eventRepository,
                              HappenRepository happenRepository,
                              ReservationRepository reservationRepository,
                              CustomerRepository customerRepository) {
        this.seatRepository = seatRepository;
        this.roomRepository = roomRepository;
        this.eventRepository = eventRepository;
        this.happenRepository = happenRepository;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
   }

    public List<Reservation> getReservationsForHappen (Long happenId){
        List<Reservation> reservations = reservationRepository.findReservationsByEventHappen_Id(happenId);
        return reservations;
    }

    public void saveHappen(EventHappen happen){
        happenRepository.save(happen);

        if(reservationRepository.findReservationsByEventHappen_Id(happen.getId()).size() == 0) {
            happen.getRoom().getSeats().forEach(s -> {
                Reservation reservation = new Reservation();
                reservation.setEventHappen(happen);
                reservation.setSimpleSeat(s);
                reservationRepository.save(reservation);
            });
        }
    }

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<EventHappen> getFromPeriod(LocalDate from, LocalDate to) {
        List<EventHappen> happen = happenRepository.findAllByDateStartBetweenOrderByDateStartAscTimeStartAsc(from, to);
        return happen;
    }

    public Map<Long,String> getRooms() {
        Map<Long,String> rooms = new HashMap<>();
        roomRepository.findAll().forEach((room) -> rooms.put(room.getId(), room.getName()));
        return rooms;
    }

    public Optional<EventHappen> getHappen(Long id){
        return happenRepository.findById(id);
    }
    public Optional<Reservation> getReservation(Long id) {
        return reservationRepository.findById(id);
    }

    /* For <select> list of events in "ADD" template */
    public Map<Long,String> getEvents() {
        Map<Long,String> events = new HashMap<>();
        eventRepository.findAll().forEach((event) -> events.put(event.getId(), event.getName()));
        return events;
    }

}
