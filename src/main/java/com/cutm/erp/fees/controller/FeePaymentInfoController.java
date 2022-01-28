package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.FeePaymentInfo;
import com.cutm.erp.fees.service.FeePaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/feePayment/")
public class FeePaymentInfoController {
    @Autowired
    private FeePaymentInfoService feePaymentInfoService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<FeePaymentInfo> getAll(){
        return feePaymentInfoService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody FeePaymentInfo getFeePaymentInfoById(@RequestParam(name="feePaymentInfoId")Integer feePaymentInfoId){
        return feePaymentInfoService.getFeePaymentInfoById(feePaymentInfoId);
    }

    @PostMapping(value="searchByStudentId")
    public @ResponseBody List<FeePaymentInfo> getFeePaymentInfoByStudentId(@RequestParam(name="studentId")Integer studentId){
        return feePaymentInfoService.getFeePaymentInfoByStudentId(studentId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody FeePaymentInfo feePaymentInfo){
        if(feePaymentInfoService.add(feePaymentInfo))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody FeePaymentInfo feePaymentInfo){
        if(feePaymentInfoService.update(feePaymentInfo))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "feePaymentInfoId")Integer feePaymentInfoId){
        if(feePaymentInfoService.delete(feePaymentInfoId))
            return success;
        return failed;
    }
}
