package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.HostelMaster;
import com.cutm.erp.fees.entity.HostelStay;
import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.HostelStayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HostelStayService {
    @Autowired
    private HostelStayRepository hostelStayRepository;
    @Autowired
    private HostelMasterService hostelMasterService;
    @Autowired
    private StudentDetailService studentDetailService;
    public List<HostelStay> list(){
        return hostelStayRepository.findAll();
    }

    public List<HostelStay> getHostelStayByStudentId(Integer studentId) {
        return hostelStayRepository.getHostelStayByStudentId(studentId);
    }

    public HostelStay getHostelStayByHostelStayId(Integer hostelStayId){
        return hostelStayRepository.getById(hostelStayId);
    }

    public boolean add(HostelStay hostelStay) {
        HostelStay hostelStayEntity=new HostelStay();
        HostelMaster hostelMaster=hostelMasterService.getHostelMasterById(hostelStay.getHostelMasterId());
        if(hostelMaster!=null) {
            hostelStayEntity.setHostelMaster(hostelMaster);
            StudentDetail studentDetail = studentDetailService.getStudentById(hostelStay.getStudentId());
            hostelStayEntity.setStudent(studentDetail);
            hostelStayEntity.setRoomCategory(hostelStay.getRoomCategory());
            hostelStayEntity.setDateOfJoining(hostelStay.getDateOfJoining());
            hostelStayEntity.setDateOfLeave(hostelStay.getDateOfLeave());
            hostelStayRepository.save(hostelStayEntity);
            return true;
        }
        return false;
    }

    public boolean update(HostelStay hostelStay) {
        HostelStay hostelStayEntity=getHostelStayByHostelStayId(hostelStay.getHostelStayId());
        if(hostelStayEntity!=null){
            hostelStayEntity.setDateOfLeave(hostelStay.getDateOfLeave());
            hostelStayEntity.setRoomCategory(hostelStay.getRoomCategory());
            hostelStayEntity.setDateOfJoining(hostelStay.getDateOfJoining());
            hostelStayRepository.save(hostelStayEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer hostelStayId) {
        HostelStay hostelStayEntity=getHostelStayByHostelStayId(hostelStayId);
        if(hostelStayEntity!=null){
            hostelStayRepository.deleteById(hostelStayId);
            return true;
        }
        return false;
    }
}