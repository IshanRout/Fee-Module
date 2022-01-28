package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.RouteSet;
import com.cutm.erp.fees.entity.TransportationMaster;
import com.cutm.erp.fees.repository.TransportationMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportationMasterService {
    @Autowired
    private TransportationMasterRepository transportationMasterRepository;
    @Autowired
    private RouteSetService routeSetService;

    public List<TransportationMaster> list() {
        return transportationMasterRepository.findAll();
    }

    public TransportationMaster getTransportationMasterById(Integer transportationMasterId){
        return transportationMasterRepository.getById(transportationMasterId);
    }

    public boolean add(TransportationMaster transportationMaster) {
        TransportationMaster transportationMasterEntity=new TransportationMaster();
        RouteSet routeSet=routeSetService.getRouteById(transportationMaster.getRouteSetId());
        if(routeSet!=null){
            transportationMasterEntity.setRoute(routeSet);
            transportationMasterEntity.setRouteName(transportationMaster.getRouteName());
            transportationMasterEntity.setVehicleNumber(transportationMaster.getVehicleNumber());
            transportationMasterRepository.save(transportationMasterEntity);
            return true;
        }
        return false;
    }

    public boolean update(TransportationMaster transportationMaster) {
        TransportationMaster transportationMasterEntity=getTransportationMasterById(transportationMaster.getTransportationId());
        if(transportationMasterEntity!=null){
            transportationMasterEntity.setVehicleNumber(transportationMaster.getVehicleNumber());
            transportationMasterEntity.setRouteName(transportationMaster.getRouteName());
            transportationMasterRepository.save(transportationMasterEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer transportationMasterId) {
        TransportationMaster transportationMasterEntity=getTransportationMasterById(transportationMasterId);
        if(transportationMasterEntity!=null){
            transportationMasterRepository.deleteById(transportationMasterId);
            return true;
        }
        return false;
    }
}