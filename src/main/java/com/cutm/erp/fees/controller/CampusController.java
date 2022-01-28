package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/campus/")
public class CampusController {

    @Autowired
    private CampusService campusService;

    @PostMapping(value = "list")
    public @ResponseBody List<Campus> getAll(){
        return campusService.getAllCampus();
    }

    @PostMapping(value = "search")
    public @ResponseBody Campus getCampusById(@RequestParam(value = "campusId") Integer campusId){
        return campusService.getCampusById(campusId);
    }
}