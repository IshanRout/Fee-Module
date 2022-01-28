package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.StudentTransportation;
import com.cutm.erp.fees.service.StudentTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/studentTransportation/")
public class StudentTransportationController {
    @Autowired
    private StudentTransportationService transportationService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody
    List<StudentTransportation> getAll(){
        return transportationService.getAll();
    }

    @PostMapping(value="searchByStudent")
    public @ResponseBody List<StudentTransportation> getTransportByStudent(@RequestParam(name="studentId")Integer studentId){
        return transportationService.getTransportByStudent(studentId);
    }

    @PostMapping(value="search")
    public @ResponseBody
    StudentTransportation getTransportById(@RequestParam(name="transportationId")Integer transportationId){
        return transportationService.getTransportById(transportationId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody StudentTransportation studentTransportation){
        if(transportationService.add(studentTransportation))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody StudentTransportation studentTransportation){
        if(transportationService.update(studentTransportation))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "transportationId")Integer transportationId){
        if(transportationService.delete(transportationId))
            return success;
        return failed;
    }
}
