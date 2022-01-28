package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.HostelStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HostelStayRepository extends JpaRepository<HostelStay,Integer> {

    @Query("select hostel from HostelStay hostel where hostel.student.studentId=?1")
    List<HostelStay> getHostelStayByStudentId(Integer studentId);
}