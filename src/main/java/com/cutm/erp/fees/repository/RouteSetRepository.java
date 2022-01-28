package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.RouteSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteSetRepository extends JpaRepository<RouteSet,Integer> {

    @Query("select routeName from RouteSet routeName where routeName.routeSetName=?1")
    RouteSet findByName(String routeSetName);

    @Query("select route from RouteSet route where route.campus.campusId=?1")
    List<RouteSet> getRouteByCampus(Integer campusId);
}