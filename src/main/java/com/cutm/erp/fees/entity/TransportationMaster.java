package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transportation_master")
public class TransportationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportationId;
    private String routeName;
    private int vehicleNumber;

    @ManyToOne(targetEntity = RouteSet.class)
    @JoinColumn(name = "route_set_id")
    private RouteSet routeSet;

    @ManyToOne(targetEntity = TransportPickupLocation.class)
    @JoinColumn(name="transport_pickup_id")
    @JsonIgnore
    private TransportPickupLocation transportPickupLocation;

    public int getTransportationId() {
        return transportationId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setRoute(RouteSet route) {
        this.routeSet = route;
    }

    public int getRouteSetId() {
        return routeSet.getRouteSetId();
    }

    public void setRouteSet(RouteSet routeSet) {
        this.routeSet = routeSet;
    }
}