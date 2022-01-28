package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.MiscellaneousFeeMaster;
import com.cutm.erp.fees.service.MiscellaneousFeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/misc/")
public class MiscellaneousFeeMasterController {
    @Autowired
    private MiscellaneousFeeMasterService miscellaneousFeeMasterService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<MiscellaneousFeeMaster> getAll(){
        return miscellaneousFeeMasterService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody MiscellaneousFeeMaster getMiscFeeById(@RequestParam(name="miscId")Integer miscId){
        return miscellaneousFeeMasterService.getMiscFeeById(miscId);
    }

    @PostMapping(value="searchByHead")
    public @ResponseBody List<MiscellaneousFeeMaster> getMiscFeeByMiscHeadId(@RequestParam(name="miscHeadId")Integer miscHeadId){
        return miscellaneousFeeMasterService.getMiscFeeByMiscHeadId(miscHeadId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody MiscellaneousFeeMaster miscellaneousFeeMaster){
        if(miscellaneousFeeMasterService.add(miscellaneousFeeMaster))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody MiscellaneousFeeMaster miscellaneousFeeMaster){
        if(miscellaneousFeeMasterService.update(miscellaneousFeeMaster))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "miscId")Integer miscId){
        if(miscellaneousFeeMasterService.delete(miscId))
            return success;
        return failed;
    }

}