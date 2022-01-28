package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.TransportationFeeMaster;
import com.cutm.erp.fees.service.TransportationFeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/transportationFee/")
public class TransportationFeeMasterController {
    @Autowired
    private TransportationFeeMasterService transportationFeeMasterService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<TransportationFeeMaster> getAll(){
        return transportationFeeMasterService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody TransportationFeeMaster getTransportationFeeById(@RequestParam(name="transportFeeId")Integer transportFeeId){
        return transportationFeeMasterService.getTransportationFeeById(transportFeeId);
    }

    @PostMapping(value="searchByRouteId")
    public @ResponseBody List<TransportationFeeMaster> getTransportFeeByRouteId(@RequestParam(name="routeSetId")Integer routeSetId){
        return transportationFeeMasterService.getTransportFeeByRouteId(routeSetId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody TransportationFeeMaster transportationFeeMaster){
        if(transportationFeeMasterService.add(transportationFeeMaster))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody TransportationFeeMaster transportationFeeMaster){
        if(transportationFeeMasterService.update(transportationFeeMaster))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "transportFeeId")Integer transportFeeId){
        if(transportationFeeMasterService.delete(transportFeeId))
            return success;
        return failed;
    }
}