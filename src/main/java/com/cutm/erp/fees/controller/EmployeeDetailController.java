package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.EmployeeDetail;
import com.cutm.erp.fees.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/employee/")
public class EmployeeDetailController {

    @Autowired
    EmployeeDetailService employeeDetailService;

    @PostMapping(value = "list")
    public @ResponseBody List<EmployeeDetail> getAll(){
        return employeeDetailService.findAll();
    }

    @PostMapping(value = "search")
    public @ResponseBody EmployeeDetail getEmployeeByEmployeeId(@RequestParam(value="employeeId") Integer employeeId){
        return employeeDetailService.getEmployeeByEmployeeId(employeeId);
    }
}
