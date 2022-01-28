package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Branch;
import com.cutm.erp.fees.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public List<Branch> getBranchByProgramme(Integer programmeId) {
        return branchRepository.getBranchByProgramme(programmeId);
    }
    public Branch getBranchById(Integer branchId){
        return branchRepository.getById(branchId);
    }
}