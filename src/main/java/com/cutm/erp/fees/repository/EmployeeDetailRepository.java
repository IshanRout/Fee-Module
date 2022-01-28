package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail,Integer> {
}
