package com.github.hexronimo.seatsreservation.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "HAPPEN")
public class EventHappen {
    @Id
    @Column(name = "ID_HAPPEN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EVENT")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROOM")
    private SimpleRoom room;

    @Column(name = "DATE_START")
    private LocalDate dateStart;
    @Column(name = "TIME_START")
    private LocalTime timeStart;

    @Column(name = "DATE_END")
    private LocalDate dateEnd;
    @Column(name = "TIME_END")
    private LocalTime timeEnd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    //public void setDateStart(LocalDate dateStart) { this.dateStart = dateStart; }

    public void setDateStart(String dateStart) {
        this.dateStart = LocalDate.parse(dateStart);
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    //public void setTimeStart(LocalTime timeStart) { this.timeStart = timeStart; }

    public void setTimeStart(String timeStart) {
        this.timeStart = LocalTime.parse(timeStart);
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        if (dateEnd != null) {
            this.dateEnd = LocalDate.parse(dateEnd);
        } else {
            this.dateEnd = dateStart;
        }
    }

    // public void setDateEnd(LocalDate dateEnd) { this.dateEnd = dateEnd; }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    //public void setTimeEnd(LocalTime timeEnd) { this.timeEnd = timeEnd; }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = LocalTime.parse(timeEnd);
    }

    public SimpleRoom getRoom() {
        return room;
    }

    public void setRoom(SimpleRoom room) {
        this.room = room;
    }
}
