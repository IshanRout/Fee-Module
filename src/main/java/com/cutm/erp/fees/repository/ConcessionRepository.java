package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.Concession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcessionRepository extends JpaRepository<Concession,Integer> {
    @Query("select concession from Concession concession where concession.studentDetail.studentId=?1")
    List<Concession> getConcessionByStudentId(Integer studentId);
}
