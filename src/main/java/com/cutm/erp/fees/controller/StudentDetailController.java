package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.service.StudentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/studentDetail/")
public class StudentDetailController {
    @Autowired
    private StudentDetailService studentDetailService;

    @PostMapping(value = "list")
    public @ResponseBody List<StudentDetail> list(){
        return studentDetailService.list();
    }

    @PostMapping(value = "search")
    public @ResponseBody StudentDetail getStudentById(@RequestParam(value = "studentId")Integer studentId){
        return studentDetailService.getStudentById(studentId);
    }
}
