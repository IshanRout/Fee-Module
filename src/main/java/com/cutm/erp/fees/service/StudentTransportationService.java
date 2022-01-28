package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.entity.StudentTransportation;
import com.cutm.erp.fees.entity.TransportPickupLocation;
import com.cutm.erp.fees.entity.TransportationMaster;
import com.cutm.erp.fees.repository.StudentTransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTransportationService {
    @Autowired private StudentTransportationRepository transportationRepository;
    @Autowired private StudentDetailService studentDetailService;
    @Autowired private TransportationMasterService transportationMasterService;
    @Autowired private TransportPickupLocationService transportPickupLocationService;
    public List<StudentTransportation> getAll() {
        return transportationRepository.findAll();
    }

    public List<StudentTransportation> getTransportByStudent(Integer studentId) {
        return transportationRepository.getTransportByStudent(studentId);
    }

    public StudentTransportation getTransportById(Integer transportationId) {
        return transportationRepository.getById(transportationId);
    }

    public boolean add(StudentTransportation transportation) {
        StudentTransportation transportationEntity=new StudentTransportation();
        StudentDetail studentDetail=studentDetailService.getStudentById(transportation.getStudentId());
        if(studentDetail!=null){
            transportationEntity.setStudent(studentDetail);
            TransportationMaster transportationMaster=transportationMasterService.getTransportationMasterById(transportation.getTransportationMasterId());
            TransportPickupLocation transportPickupLocation=transportPickupLocationService.getPickupLocationByTransportPickupId(transportation.getTransportPickupLocationId());
            transportationEntity.setTransportPickupLocation(transportPickupLocation);
            transportationEntity.setTransportationMaster(transportationMaster);
            transportationEntity.setDateOfIssue(transportation.getDateOfIssue());
            transportationEntity.setDateOfIssue(transportation.getDateOfIssue());
            transportationRepository.save(transportationEntity);
            return true;
        }
        return false;
    }

    public boolean update(StudentTransportation transportation) {
        StudentTransportation transportationEntity=getTransportById(transportation.getStudentTransportationId());
        if(transportationEntity!=null){
            transportationEntity.setDateOfIssue(transportation.getDateOfIssue());
            transportationEntity.setDateOfIssue(transportation.getDateOfIssue());
            transportationRepository.save(transportationEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer transportationId) {
        StudentTransportation transportationEntity=getTransportById(transportationId);
        if(transportationEntity!=null){
            transportationRepository.deleteById(transportationId);
            return true;
        }
        return false;
    }
}