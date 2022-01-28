package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "route_set")
public class RouteSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeSetId;
    private String routeSetName;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    public int getRouteSetId() {
        return routeSetId;
    }

    public String getRouteSetName() {
        return routeSetName;
    }

    public void setRouteSetName(String routeSetName) {
        this.routeSetName = routeSetName;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getCampusId(){
        return campus.getCampusId();
    }
}