package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.FeePaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeePaymentInfoRepository extends JpaRepository<FeePaymentInfo,Integer> {

    @Query("select fee from FeePaymentInfo fee where fee.studentDetail.studentId=?1")
    List<FeePaymentInfo> getFeePaymentInfoByStudentId(Integer studentId);
}
