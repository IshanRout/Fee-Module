package com.cutm.erp.fees.controller;
import com.cutm.erp.fees.entity.AcademicFeeMaster;
import com.cutm.erp.fees.service.AcademicFeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/academicFee/")
public class AcademicFeeMasterController {
    @Autowired
    private AcademicFeeMasterService academicFeeMasterService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody
    List<AcademicFeeMaster> getAll(){
        return academicFeeMasterService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody AcademicFeeMaster getAcademicFeeByAcademicFeeId(@RequestParam(name="academicFeeMasterId")Integer academicFeeMasterId){
        return academicFeeMasterService.getAcademicFeeByAcademicFeeId(academicFeeMasterId);
    }

    @PostMapping(value="searchByProgram")
    public @ResponseBody List<AcademicFeeMaster> getAcademicFeeByProgramId(@RequestParam(name="programmeId")Integer programmeId){
        return academicFeeMasterService.getAcademicFeeByProgramId(programmeId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody AcademicFeeMaster academicFeeMaster){
        if(academicFeeMasterService.add(academicFeeMaster))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody AcademicFeeMaster academicFeeMaster){
        if(academicFeeMasterService.update(academicFeeMaster))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "AcademicFeeMasterId")Integer academicFeeMasterId){
        if(academicFeeMasterService.delete(academicFeeMasterId))
            return success;
        return failed;
    }
}
