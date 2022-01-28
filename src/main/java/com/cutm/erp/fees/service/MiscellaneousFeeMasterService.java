package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.*;
import com.cutm.erp.fees.repository.MiscellaneousFeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscellaneousFeeMasterService {

    @Autowired private MiscellaneousFeeMasterRepository miscellaneousFeeMasterRepository;
    @Autowired private MiscellaneousHeadService miscellaneousHeadService;
    @Autowired private CampusService campusService;
    @Autowired private ProgrammeService programmeService;
    @Autowired private BranchService branchService;

    public List<MiscellaneousFeeMaster> getAll() {
        return miscellaneousFeeMasterRepository.findAll();
    }

    public MiscellaneousFeeMaster getMiscFeeById(Integer miscId) {
        return miscellaneousFeeMasterRepository.getById(miscId);
    }

    public List<MiscellaneousFeeMaster> getMiscFeeByMiscHeadId(Integer miscHeadId) {
        return miscellaneousFeeMasterRepository.getMiscFeeByMiscHeadId(miscHeadId);
    }

    public boolean add(MiscellaneousFeeMaster miscellaneousFeeMaster) {
        MiscellaneousFeeMaster miscellaneousFeeMasterEntity=new MiscellaneousFeeMaster();
        MiscellaneousHead miscellaneousHead=miscellaneousHeadService.getMiscHeadById(miscellaneousFeeMaster.getMiscellaneousHeadId());
        if(miscellaneousHead!=null){
            miscellaneousFeeMasterEntity.setMiscellaneousHead(miscellaneousHead);
            Campus campus=campusService.getCampusById(miscellaneousFeeMaster.getCampusId());
            Programme programme=programmeService.getProgrammeById(miscellaneousFeeMaster.getProgrammeId());
            Branch branch=branchService.getBranchById(miscellaneousFeeMaster.getBranchId());
            miscellaneousFeeMasterEntity.setCampus(campus);
            miscellaneousFeeMasterEntity.setBranch(branch);
            miscellaneousFeeMasterEntity.setProgramme(programme);
            miscellaneousFeeMasterEntity.setAmount(miscellaneousFeeMaster.getAmount());
            miscellaneousFeeMasterEntity.setSemester(miscellaneousFeeMaster.getSemester());
            miscellaneousFeeMasterEntity.setAcademicYear(miscellaneousFeeMaster.getAcademicYear());
            miscellaneousFeeMasterRepository.save(miscellaneousFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean update(MiscellaneousFeeMaster miscellaneousFeeMaster) {
        MiscellaneousFeeMaster miscellaneousFeeMasterEntity=getMiscFeeById(miscellaneousFeeMaster.getMiscellaneousFeeId());
        if(miscellaneousFeeMasterEntity!=null){
            miscellaneousFeeMasterEntity.setAmount(miscellaneousFeeMaster.getAmount());
            miscellaneousFeeMasterEntity.setSemester(miscellaneousFeeMaster.getSemester());
            miscellaneousFeeMasterEntity.setAcademicYear(miscellaneousFeeMaster.getAcademicYear());
            miscellaneousFeeMasterRepository.save(miscellaneousFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer miscId) {
    MiscellaneousFeeMaster miscellaneousFeeMaster=getMiscFeeById(miscId);
    if(miscellaneousFeeMaster!=null){
        miscellaneousFeeMasterRepository.deleteById(miscId);
        return true;
    }
    return false;
    }
}