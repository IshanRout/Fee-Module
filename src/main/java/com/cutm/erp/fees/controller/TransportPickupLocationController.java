package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.TransportPickupLocation;
import com.cutm.erp.fees.service.TransportPickupLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/transportPickup/")
public class TransportPickupLocationController {
    @Autowired
    private TransportPickupLocationService transportPickupLocationService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<TransportPickupLocation> list (){
        return transportPickupLocationService.list();
    }

    @PostMapping(value="search")
    public @ResponseBody TransportPickupLocation getPickupLocationByTransportPickupId(@RequestParam(name="transportPickupId") Integer transportPickupId){
        return transportPickupLocationService.getPickupLocationByTransportPickupId(transportPickupId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody TransportPickupLocation transportPickupLocation){
        if(transportPickupLocationService.add(transportPickupLocation))
            return success;
        return failed;
    }

    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody TransportPickupLocation transportPickupLocation){
        if(transportPickupLocationService.update(transportPickupLocation))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "transportPickupId")Integer transportPickupId){
        if(transportPickupLocationService.delete(transportPickupId))
            return success;
        return failed;
    }
}
