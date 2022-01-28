package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.TransportationMaster;
import com.cutm.erp.fees.service.TransportationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/transportationMaster")
public class TransportationMasterController {
    @Autowired
    private TransportationMasterService transportationMasterService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody
    List<TransportationMaster> getAll(){
        return transportationMasterService.list();
    }

    @PostMapping(value = "search")
    public @ResponseBody TransportationMaster getTransportationMasterById(@RequestParam(value = "transportMasterId")Integer transportMasterId){
        return transportationMasterService.getTransportationMasterById(transportMasterId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody TransportationMaster transportationMaster){
        if(transportationMasterService.add(transportationMaster))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody TransportationMaster transportationMaster){
        if(transportationMasterService.update(transportationMaster))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "transportationMasterId")Integer transportationMasterId){
        if(transportationMasterService.delete(transportationMasterId))
            return success;
        return failed;
    }
}