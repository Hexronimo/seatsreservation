package com.github.hexronimo.seatsreservation.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "EVENT")
public class Event {
    @Id
    @Column(name = "ID_EVENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INFO")
    private String info;


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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
