package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch,Integer> {

    @Query("select branch from Branch branch where branch.programme.programmeId=?1")
    List<Branch> getBranchByProgramme(Integer programmeId);
}