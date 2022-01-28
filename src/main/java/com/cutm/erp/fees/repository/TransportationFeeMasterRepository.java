package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.TransportationFeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportationFeeMasterRepository extends JpaRepository<TransportationFeeMaster, Integer> {

    @Query("select fee from TransportationFeeMaster fee where fee.route.routeSetId=?1")
    List<TransportationFeeMaster> getTransportFeeByRouteId(Integer routeSetId);
}
