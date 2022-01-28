package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.RouteSet;
import com.cutm.erp.fees.service.RouteSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/routeSet/")
public class RouteSetController {
    @Autowired
    private RouteSetService routeSetService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<RouteSet> getAll(){
        return routeSetService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody List<RouteSet> getRouteByCampus(@RequestParam(name="campusId")Integer campusId){
        return routeSetService.getRouteByCampus(campusId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody RouteSet routeSet){
        if(routeSetService.add(routeSet))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody RouteSet routeSet){
        if(routeSetService.update(routeSet))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "routeSetId")Integer routeSetId){
        if(routeSetService.delete(routeSetId))
            return success;
        return failed;
    }
}