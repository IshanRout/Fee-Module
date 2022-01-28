package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.entity.HostelFeeMaster;
import com.cutm.erp.fees.entity.Programme;
import com.cutm.erp.fees.repository.HostelFeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelFeeMasterService {
    @Autowired private HostelFeeMasterRepository hostelFeeMasterRepository;
    @Autowired private CampusService campusService;
    @Autowired private ProgrammeService programmeService;

    public List<HostelFeeMaster> getAll() {
        return hostelFeeMasterRepository.findAll();
    }

    public HostelFeeMaster getHostelFeeMasterById(Integer hostelFeeMasterId) {
        return hostelFeeMasterRepository.getById(hostelFeeMasterId);
    }

    public boolean add(HostelFeeMaster hostelFeeMaster) {
        HostelFeeMaster hostelFeeMasterEntity=new HostelFeeMaster();
        Campus campus=campusService.getCampusById(hostelFeeMaster.getCampusId());
        if(campus!=null){
            hostelFeeMasterEntity.setCampus(campus);
            Programme programme=programmeService.getProgrammeById(hostelFeeMaster.getProgrammeId());
            hostelFeeMasterEntity.setProgramme(programme);
            hostelFeeMasterEntity.setFee(hostelFeeMaster.getFee());
            hostelFeeMasterEntity.setFeeFrom(hostelFeeMaster.getFeeFrom());
            hostelFeeMasterEntity.setFeeUpTo(hostelFeeMaster.getFeeUpTo());
            hostelFeeMasterEntity.setAcademicYear(hostelFeeMaster.getAcademicYear());
            hostelFeeMasterEntity.setDueDate(hostelFeeMaster.getDueDate());
            hostelFeeMasterEntity.setRoomCategory(hostelFeeMaster.getRoomCategory());
            hostelFeeMasterRepository.save(hostelFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean update(HostelFeeMaster hostelFeeMaster) {
        HostelFeeMaster hostelFeeMasterEntity=getHostelFeeMasterById(hostelFeeMaster.getHostelFeeMasterId());
        if(hostelFeeMasterEntity!=null){
            hostelFeeMasterEntity.setFee(hostelFeeMaster.getFee());
            hostelFeeMasterEntity.setFeeFrom(hostelFeeMaster.getFeeFrom());
            hostelFeeMasterEntity.setFeeUpTo(hostelFeeMaster.getFeeUpTo());
            hostelFeeMasterEntity.setAcademicYear(hostelFeeMaster.getAcademicYear());
            hostelFeeMasterEntity.setDueDate(hostelFeeMaster.getDueDate());
            hostelFeeMasterEntity.setRoomCategory(hostelFeeMaster.getRoomCategory());
            hostelFeeMasterRepository.save(hostelFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer hostelFeeMasterId) {
        HostelFeeMaster hostelFeeMaster=getHostelFeeMasterById(hostelFeeMasterId);
        if(hostelFeeMaster!=null){
            hostelFeeMasterRepository.deleteById(hostelFeeMasterId);
            return true;
        }
        return false;
    }
}