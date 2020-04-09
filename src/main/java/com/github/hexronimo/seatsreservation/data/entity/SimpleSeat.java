package com.github.hexronimo.seatsreservation.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "SEAT")
public class SimpleSeat {
    /**
     * Самая простая реализация Места
     * ID - оставлено для поддержки БД
     * name - имя в свободной форме, которое может быть задано / сгенерировано на фронтэнде, например, "21П"
     * room - принадлежность к комнате, сделана для сопряжения с БД (одна комната -< много мест)
     * */

    @Id
    @Column(name = "ID_SEAT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ROOM")
    private SimpleRoom room;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleRoom getRoom() {
        return room;
    }

    public void setRoom(SimpleRoom room) {
        this.room = room;
    }


}
