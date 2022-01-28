package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Programme;
import com.cutm.erp.fees.service.ProgrammeService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/programme/")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    @PostMapping(value = "list")
    public @ResponseBody List<Programme> getAllProgramme(){
        return programmeService.getAllProgramme();
    }

    @PostMapping(value = "search")
    public @ResponseBody Programme getProgrammeById(@RequestParam (value = "programmeId") Integer programmeId){
        return programmeService.getProgrammeById(programmeId);
    }
}