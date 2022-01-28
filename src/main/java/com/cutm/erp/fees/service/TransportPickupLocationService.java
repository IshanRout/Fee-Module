package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.TransportPickupLocation;
import com.cutm.erp.fees.entity.TransportationMaster;
import com.cutm.erp.fees.repository.TransportPickupLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransportPickupLocationService {

    @Autowired
    private TransportPickupLocationRepository transportPickupLocationRepository;
    @Autowired
    private TransportationMasterService transportationMasterService;

    public List<TransportPickupLocation> list() {
        return transportPickupLocationRepository.findAll();
    }

    public TransportPickupLocation getPickupLocationByTransportPickupId(Integer transportPickupId) {
        return transportPickupLocationRepository.getById(transportPickupId);
    }

    public boolean add(TransportPickupLocation transportPickupLocation) {
        TransportPickupLocation transportPickupLocationEntity=new TransportPickupLocation();
        List<TransportationMaster> transportationMaster=transportPickupLocation.getTransportationMaster();
        if(transportationMaster!=null){
            transportPickupLocationEntity.setTransportationMaster(transportationMaster);
            transportPickupLocationEntity.setLocation(transportPickupLocation.getLocation());
            transportPickupLocationEntity.setTimeOfPickup(transportPickupLocation.getTimeOfPickup());
            transportPickupLocationRepository.save(transportPickupLocationEntity);
            return true;
        }
        return false;
    }

    public boolean update(TransportPickupLocation transportPickupLocation) {
        TransportPickupLocation transportPickupLocationEntity=new TransportPickupLocation();
        List<TransportationMaster> transportationMaster=transportPickupLocation.getTransportationMaster();
        if(transportationMaster!=null){
            transportPickupLocationEntity.setTransportationMaster(transportationMaster);
            transportPickupLocationEntity.setLocation(transportPickupLocation.getLocation());
            transportPickupLocationEntity.setTimeOfPickup(transportPickupLocation.getTimeOfPickup());
            transportPickupLocationRepository.save(transportPickupLocationEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer transportPickupId){
        TransportPickupLocation transportPickupLocation=getPickupLocationByTransportPickupId(transportPickupId);
        if(transportPickupLocation!=null) {
            transportPickupLocationRepository.deleteById(transportPickupId);
            return true;
        }
        return false;
    }
}