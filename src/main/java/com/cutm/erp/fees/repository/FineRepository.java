package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FineRepository extends JpaRepository<Fine,Integer> {

    @Query("select fine from Fine fine where fine.studentDetail.studentId=?1")
    List<Fine> getFineByStudentId(Integer studentId);
}
