package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.entity.RouteSet;
import com.cutm.erp.fees.entity.TransportationFeeMaster;
import com.cutm.erp.fees.repository.TransportationFeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportationFeeMasterService {
    @Autowired private TransportationFeeMasterRepository transportationFeeMasterRepository;
    @Autowired private RouteSetService routeSetService;
    @Autowired private CampusService campusService;

    public List<TransportationFeeMaster> getAll() {
        return transportationFeeMasterRepository.findAll();
    }

    public TransportationFeeMaster getTransportationFeeById(Integer transportFeeId) {
        return transportationFeeMasterRepository.getById(transportFeeId);
    }

    public List<TransportationFeeMaster> getTransportFeeByRouteId(Integer routeSetId) {
        return transportationFeeMasterRepository.getTransportFeeByRouteId(routeSetId);
    }

    public boolean add(TransportationFeeMaster transportationFeeMaster) {
        TransportationFeeMaster transportationFeeMasterEntity=new TransportationFeeMaster();
        RouteSet routeSet=routeSetService.getRouteById(transportationFeeMaster.getRouteId());
        if(routeSet!=null){
            transportationFeeMasterEntity.setRoute(routeSet);
            Campus campus=campusService.getCampusById(transportationFeeMaster.getCampusId());
            transportationFeeMasterEntity.setCampus(campus);
            transportationFeeMasterEntity.setAcademicYear(transportationFeeMaster.getAcademicYear());
            transportationFeeMasterEntity.setValidationDate(transportationFeeMaster.getValidationDate());
            transportationFeeMasterEntity.setFeePerYear(transportationFeeMaster.getFeePerYear());
            transportationFeeMasterRepository.save(transportationFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean update(TransportationFeeMaster transportationFeeMaster) {
        TransportationFeeMaster transportationFeeMasterEntity=getTransportationFeeById(transportationFeeMaster.getTransportationFeeMasterId());
        if(transportationFeeMasterEntity!=null){
            transportationFeeMasterEntity.setAcademicYear(transportationFeeMaster.getAcademicYear());
            transportationFeeMasterEntity.setValidationDate(transportationFeeMaster.getValidationDate());
            transportationFeeMasterEntity.setFeePerYear(transportationFeeMaster.getFeePerYear());
            transportationFeeMasterRepository.save(transportationFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer transportFeeId) {
        TransportationFeeMaster transportationFeeMaster=getTransportationFeeById(transportFeeId);
        if(transportationFeeMaster!=null){
            transportationFeeMasterRepository.deleteById(transportFeeId);
            return true;
        }
        return false;
    }
}