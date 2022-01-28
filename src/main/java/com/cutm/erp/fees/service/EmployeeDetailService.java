package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.EmployeeDetail;
import com.cutm.erp.fees.repository.EmployeeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailService {
    @Autowired
    EmployeeDetailRepository employeeDetailRepository;

    public List<EmployeeDetail> findAll(){
        return employeeDetailRepository.findAll();
    }
    public EmployeeDetail getEmployeeByEmployeeId(Integer employeeId){
        return employeeDetailRepository.getById(employeeId);
    }
}