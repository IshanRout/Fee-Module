package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.MiscellaneousFeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MiscellaneousFeeMasterRepository extends JpaRepository<MiscellaneousFeeMaster,Integer> {

    @Query("select misc from MiscellaneousFeeMaster misc where misc.miscellaneousHead.miscellaneousHeadId=?1")
    List<MiscellaneousFeeMaster> getMiscFeeByMiscHeadId(Integer miscHeadId);
}
