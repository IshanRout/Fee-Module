package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefundRepository extends JpaRepository<Refund,Integer> {

    @Query("select refund from Refund refund where refund.studentDetail.studentId=?1")
    List<Refund> getRefundByStudentId(Integer studentId);
}
