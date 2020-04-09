package com.github.hexronimo.seatsreservation.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "ID_RESERVATION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HAPPEN")
    private EventHappen eventHappen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SEAT")
    private SimpleSeat simpleSeat;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CUSTOMER")
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EventHappen getEventHappen() {
        return eventHappen;
    }

    public void setEventHappen(EventHappen eventHappen) {
        this.eventHappen = eventHappen;
    }

    public SimpleSeat getSimpleSeat() {
        return simpleSeat;
    }

    public void setSimpleSeat(SimpleSeat simpleSeat) {
        this.simpleSeat = simpleSeat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
