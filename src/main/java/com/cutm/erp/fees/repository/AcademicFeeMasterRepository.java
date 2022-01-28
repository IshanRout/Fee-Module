package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.AcademicFeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcademicFeeMasterRepository extends JpaRepository<AcademicFeeMaster,Integer> {

    @Query("select fee from AcademicFeeMaster fee where fee.programme.programmeId=?1")
    List<AcademicFeeMaster> getAcademicFeeByProgramId(Integer programmeId);
}
