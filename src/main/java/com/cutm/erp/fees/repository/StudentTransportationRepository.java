package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.StudentTransportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentTransportationRepository extends JpaRepository<StudentTransportation,Integer> {

    @Query("select transport from StudentTransportation transport where transport.student.studentId=?1")
    List<StudentTransportation> getTransportByStudent(Integer studentId);
}
