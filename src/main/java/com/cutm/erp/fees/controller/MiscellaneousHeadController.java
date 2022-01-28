package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Fine;
import com.cutm.erp.fees.entity.MiscellaneousHead;
import com.cutm.erp.fees.service.FineService;
import com.cutm.erp.fees.service.MiscellaneousHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/miscHead/")
public class MiscellaneousHeadController {
    @Autowired
    private MiscellaneousHeadService miscellaneousHeadService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<MiscellaneousHead> getAll(){
        return miscellaneousHeadService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody MiscellaneousHead getMiscHeadById(@RequestParam(name="miscHeadId")Integer miscHeadId){
        return miscellaneousHeadService.getMiscHeadById(miscHeadId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody MiscellaneousHead miscellaneousHead){
        if(miscellaneousHeadService.add(miscellaneousHead))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody MiscellaneousHead miscellaneousHead){
        if(miscellaneousHeadService.update(miscellaneousHead))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "miscHeadId")Integer miscHeadId){
        if(miscellaneousHeadService.delete(miscHeadId))
            return success;
        return failed;
    }
}
