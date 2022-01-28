package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.entity.RouteSet;
import com.cutm.erp.fees.repository.RouteSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteSetService {
    @Autowired
    RouteSetRepository routeSetRepository;
    @Autowired
    CampusService campusService;

    public List<RouteSet> getAll() {
        return routeSetRepository.findAll();
    }

    public List<RouteSet> getRouteByCampus(Integer campusId) {
        return routeSetRepository.getRouteByCampus(campusId);
    }

    public RouteSet getRouteById(Integer routeId){return routeSetRepository.getById(routeId);}

    public boolean add(RouteSet routeSet) {
        RouteSet routeSetEntity=new RouteSet();
        Campus campus=campusService.getCampusById(routeSet.getCampusId());
        if(campus!=null){
            routeSetEntity.setCampus(campus);
            routeSetEntity.setRouteSetName(routeSet.getRouteSetName());
            routeSetRepository.save(routeSetEntity);
            return true;
        }
        return false;
    }

    public boolean update(RouteSet routeSet) {
       RouteSet routeSetEntity=getRouteById(routeSet.getRouteSetId());
        if(routeSetEntity!=null){
            routeSetEntity.setRouteSetName(routeSet.getRouteSetName());
            routeSetRepository.save(routeSetEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer routeSetId) {
        RouteSet routeSet=getRouteById(routeSetId);
        if(routeSet!=null){
            routeSetRepository.deleteById(routeSetId);
            return true;
        }
        return false;
    }
}