package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.HostelFeeMaster;
import com.cutm.erp.fees.service.HostelFeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/hostelFeeMaster/")
public class HostelFeeMasterController {
    @Autowired
    private HostelFeeMasterService hostelFeeMasterService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<HostelFeeMaster> getAll(){
        return hostelFeeMasterService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody HostelFeeMaster getHostelFeeMasterById(@RequestParam(name="hostelFeeMasterId")Integer hostelFeeMasterId){
        return hostelFeeMasterService.getHostelFeeMasterById(hostelFeeMasterId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody HostelFeeMaster hostelFeeMaster){
        if(hostelFeeMasterService.add(hostelFeeMaster))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody HostelFeeMaster hostelFeeMaster){
        if(hostelFeeMasterService.update(hostelFeeMaster))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "hostelFeeMasterId")Integer hostelFeeMasterId){
        if(hostelFeeMasterService.delete(hostelFeeMasterId))
            return success;
        return failed;
    }
}
