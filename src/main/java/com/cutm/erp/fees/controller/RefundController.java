package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.Refund;
import com.cutm.erp.fees.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/refund/")
public class RefundController {
    @Autowired
    private RefundService refundService;
    static String success="SUCCESS";
    static String failed="FAILED";

    @PostMapping(value = "list")
    public @ResponseBody List<Refund> getAll(){
        return refundService.getAll();
    }

    @PostMapping(value="search")
    public @ResponseBody Refund getRefundById(@RequestParam(name="refundId")Integer refundId){
        return refundService.getRefundById(refundId);
    }

    @PostMapping(value="searchByStudentId")
    public @ResponseBody List<Refund> getRefundByStudentId(@RequestParam(name="studentId")Integer studentId){
        return refundService.getRefundByStudentId(studentId);
    }

    @PostMapping(value = "add")
    public @ResponseBody String add(@RequestBody Refund refund){
        if(refundService.add(refund))
            return success;
        return failed;
    }
    @PostMapping(value="update")
    public @ResponseBody String update(@RequestBody Refund refund){
        if(refundService.update(refund))
            return success;
        return failed;
    }

    @PostMapping(value = "delete")
    public @ResponseBody String delete(@RequestParam(value = "refundId")Integer refundId){
        if(refundService.delete(refundId))
            return success;
        return failed;
    }
}