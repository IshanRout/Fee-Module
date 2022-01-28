package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.StudentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailService {
    @Autowired
    private StudentDetailRepository studentDetailRepository;

    public List<StudentDetail> list() {
        return studentDetailRepository.findAll();
    }

    public StudentDetail getStudentById(Integer studentId) {
        return studentDetailRepository.getById(studentId);
    }
}
