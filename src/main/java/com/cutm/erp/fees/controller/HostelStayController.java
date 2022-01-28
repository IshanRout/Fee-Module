package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.HostelStay;
import com.cutm.erp.fees.service.HostelStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping(value = "/hostelStay/")
public class HostelStayController {
    @Autowired
    private HostelStayService hostelStayService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<HostelStay> list(){ return hostelStayService.list();}

    @PostMapping(value="search")
    public @ResponseBody List<HostelStay> getRouteByCampus(@RequestParam(name="studentId")Integer studentId){
        return hostelStayService.getHostelStayByStudentId(studentId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody HostelStay hostelStay){
        if(hostelStayService.add(hostelStay))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody HostelStay hostelStay){
        if(hostelStayService.update(hostelStay))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "hostelStayId")Integer hostelStayId){
        if(hostelStayService.delete(hostelStayId))
            return success;
        return failed;
    }
}