package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.HostelMaster;
import com.cutm.erp.fees.repository.HostelMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelMasterService {
    @Autowired
    HostelMasterRepository hostelMasterRepository;

    public List<HostelMaster> getAllHostel() {
        return hostelMasterRepository.findAll();
    }

    public List<HostelMaster> getHostelByCampus(Integer campusId) {
        return hostelMasterRepository.findHostelByCampus(campusId);
    }

    public HostelMaster getHostelMasterById(Integer hostelMasterId){
        return hostelMasterRepository.getById(hostelMasterId);
    }
}
