package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.HostelMaster;
import com.cutm.erp.fees.service.HostelMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/hostel/")
public class HostelMasterController {
    @Autowired
    HostelMasterService hostelMasterService;

    @PostMapping(value="list")
    public @ResponseBody List<HostelMaster> getAll() {
        return hostelMasterService.getAllHostel();
    }

    @PostMapping(value="search")
    public @ResponseBody List<HostelMaster> getHostelByCampus(@RequestParam(value="campusId") Integer campusId){
        return hostelMasterService.getHostelByCampus(campusId);
    }
}