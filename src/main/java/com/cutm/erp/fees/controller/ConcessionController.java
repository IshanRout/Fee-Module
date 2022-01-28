package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Concession;
import com.cutm.erp.fees.service.ConcessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/concession/")
public class ConcessionController {
    @Autowired
    private ConcessionService concessionService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<Concession> getAll(){
        return concessionService.getAll();
    }

    @PostMapping(value="searchByStudentId")
    public @ResponseBody List<Concession> getConcessionByStudentId(@RequestParam(name="studentId")Integer studentId){
        return concessionService.getConcessionByStudentId(studentId);
    }

    @PostMapping(value="search")
    public @ResponseBody Concession getConcessionByConcessionId(@RequestParam(name="concessionId")Integer concessionId){
        return concessionService.getConcessionByConcessionId(concessionId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody Concession concession){
        if(concessionService.add(concession))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody Concession concession){
        if(concessionService.update(concession))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "concessionId")Integer concessionId){
        if(  concessionService.delete(concessionId))
            return success;
        return failed;
    }
}