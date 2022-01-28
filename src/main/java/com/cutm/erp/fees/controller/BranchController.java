package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Branch;
import com.cutm.erp.fees.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/branch/")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping(value = "list")
    public @ResponseBody List<Branch> getAllBranches(){
        return branchService.findAll();
    }

    @PostMapping(value = "search")
    public @ResponseBody List<Branch> getBranchByProgramme(@RequestParam(value = "programmeId")Integer programmeId){
        return branchService.getBranchByProgramme(programmeId);
    }
}