package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDetailRepository extends JpaRepository<StudentDetail,Integer> {
}
