package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService {
    @Autowired
    private CampusRepository campusRepository;

    public List<Campus> getAllCampus() {
        return campusRepository.findAll();
    }

    public Campus getCampusById(Integer campusId){return campusRepository.getById(campusId);}
}