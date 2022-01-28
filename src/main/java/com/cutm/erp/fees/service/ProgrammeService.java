package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Programme;
import com.cutm.erp.fees.repository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammeService {
    @Autowired
    ProgrammeRepository programmeRepository;

    public List<Programme> getAllProgramme() {
        return programmeRepository.findAll();
    }

    public Programme getProgrammeById(Integer programmeId){ return programmeRepository.getById(programmeId);}
}
