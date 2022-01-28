package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.AcademicFeeMaster;
import com.cutm.erp.fees.entity.Branch;
import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.entity.Programme;
import com.cutm.erp.fees.repository.AcademicFeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicFeeMasterService {
    @Autowired private AcademicFeeMasterRepository academicFeeMasterRepository;
    @Autowired private ProgrammeService programmeService;
    @Autowired private CampusService campusService;
    @Autowired private BranchService branchService;

    public List<AcademicFeeMaster> getAll() {
        return academicFeeMasterRepository.findAll();
    }

    public AcademicFeeMaster getAcademicFeeByAcademicFeeId(Integer academicFeeMasterId) {
        return academicFeeMasterRepository.getById(academicFeeMasterId);
    }

    public List<AcademicFeeMaster> getAcademicFeeByProgramId(Integer programmeId) {
        return academicFeeMasterRepository.getAcademicFeeByProgramId(programmeId);
    }

    public boolean add(AcademicFeeMaster academicFeeMaster) {
        AcademicFeeMaster academicFeeMasterEntity=new AcademicFeeMaster();
        Programme programme=programmeService.getProgrammeById(academicFeeMaster.getProgrammeId());
        if(programme!=null){
            academicFeeMasterEntity.setProgramme(programme);
            Campus campus=campusService.getCampusById(academicFeeMaster.getCampusId());
            academicFeeMasterEntity.setCampus(campus);
            if(academicFeeMaster.getBranchId()!=null) {
                Branch branch=branchService.getBranchById(academicFeeMaster.getBranchId());
                academicFeeMasterEntity.setBranch(branch);
            }
            academicFeeMasterEntity.setTuitionFeePerYear(academicFeeMaster.getTuitionFeePerYear());
            academicFeeMasterEntity.setExamFeePerYear(academicFeeMaster.getExamFeePerYear());
            academicFeeMasterEntity.setBatchYear(academicFeeMaster.getBatchYear());
            academicFeeMasterRepository.save(academicFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean update(AcademicFeeMaster academicFeeMaster) {
        AcademicFeeMaster academicFeeMasterEntity=getAcademicFeeByAcademicFeeId(academicFeeMaster.getAcademicFeeId());
        if(academicFeeMasterEntity!=null){
            academicFeeMasterEntity.setTuitionFeePerYear(academicFeeMaster.getTuitionFeePerYear());
            academicFeeMasterEntity.setExamFeePerYear(academicFeeMaster.getExamFeePerYear());
            academicFeeMasterEntity.setBatchYear(academicFeeMaster.getBatchYear());
            academicFeeMasterRepository.save(academicFeeMasterEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer academicFeeMasterId) {
        AcademicFeeMaster academicFeeMasterEntity=getAcademicFeeByAcademicFeeId(academicFeeMasterId);
        if ((academicFeeMasterEntity!=null)){
            academicFeeMasterRepository.deleteById(academicFeeMasterId);
            return true;
        }
        return false;
    }
}