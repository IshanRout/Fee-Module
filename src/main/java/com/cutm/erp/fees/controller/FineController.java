package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Fine;
import com.cutm.erp.fees.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/fine/")
public class FineController {
    @Autowired
    private FineService fineService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<Fine> getAll(){
        return fineService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody Fine getFineById(@RequestParam(name="fineId")Integer fineId){
        return fineService.getFineById(fineId);
    }

    @PostMapping(value="searchByStudentId")
    public @ResponseBody List<Fine> getFineByStudentId(@RequestParam(name="studentId")Integer studentId){
        return fineService.getFineByStudentId(studentId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody Fine fine){
        if(fineService.add(fine))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody Fine fine){
        if(fineService.update(fine))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "fineId")Integer fineId){
        if(fineService.delete(fineId))
            return success;
        return failed;
    }
}