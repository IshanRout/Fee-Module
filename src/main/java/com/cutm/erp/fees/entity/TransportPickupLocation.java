package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "transport_pickup_location")
public class TransportPickupLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportPickupId;
    private String location;
   // @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd")
    private Time timeOfPickup;

    @OneToMany(targetEntity = TransportationMaster.class)
    @JoinColumn(name = "transport_pickup_id")
    private List<TransportationMaster> transportationMaster;

    public int getTransportPickupId() {
        return transportPickupId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Time getTimeOfPickup() {
        return timeOfPickup;
    }

    public void setTimeOfPickup(Time timeOfPickup) {
        this.timeOfPickup = timeOfPickup;
    }

    public List<TransportationMaster> getTransportationMaster() {
        return transportationMaster;
    }

    public void setTransportationMaster(List<TransportationMaster> transportationMaster) {
        this.transportationMaster = transportationMaster;
    }
}