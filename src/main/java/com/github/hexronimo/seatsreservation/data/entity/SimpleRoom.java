package com.github.hexronimo.seatsreservation.data.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class SimpleRoom {
    @Id
    @Column(name = "ID_ROOM")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INFO")
    private String info;

    @OneToMany(mappedBy = "room")
    private List<SimpleSeat> seats = new LinkedList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSeat(SimpleSeat seat) {
       seats.add(seat);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<SimpleSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<SimpleSeat> seats) {
        this.seats = seats;
    }
}
