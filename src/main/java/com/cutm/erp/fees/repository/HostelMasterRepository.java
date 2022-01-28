package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.Campus;
import com.cutm.erp.fees.entity.HostelMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HostelMasterRepository extends JpaRepository<HostelMaster,Integer> {

    @Query("select hostel from HostelMaster hostel where hostel.campus.campusId=?1")
    List<HostelMaster> findHostelByCampus(Integer campusId);
}