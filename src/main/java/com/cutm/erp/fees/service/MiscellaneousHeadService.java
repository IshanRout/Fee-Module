package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.MiscellaneousHead;
import com.cutm.erp.fees.repository.MiscellaneousHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscellaneousHeadService {
    @Autowired private MiscellaneousHeadRepository miscellaneousHeadRepository;

    public List<MiscellaneousHead> getAll() {
        return miscellaneousHeadRepository.findAll();
    }

    public MiscellaneousHead getMiscHeadById(Integer miscHeadId) {
        return miscellaneousHeadRepository.getById(miscHeadId);
    }

    public boolean add(MiscellaneousHead miscellaneousHead) {
        MiscellaneousHead miscellaneousHeadEntity=new MiscellaneousHead();
        miscellaneousHeadEntity.setHeadName(miscellaneousHead.getHeadName());
        miscellaneousHeadEntity.setOneTimePayment(miscellaneousHead.isOneTimePayment());
        miscellaneousHeadRepository.save(miscellaneousHead);
        return true;
    }

    public boolean update(MiscellaneousHead miscellaneousHead) {
        MiscellaneousHead miscellaneousHeadEntity=getMiscHeadById(miscellaneousHead.getMiscellaneousHeadId());
        if(miscellaneousHeadEntity!=null){
            miscellaneousHeadEntity.setHeadName(miscellaneousHead.getHeadName());
            miscellaneousHeadEntity.setOneTimePayment(miscellaneousHead.isOneTimePayment());
            miscellaneousHeadRepository.save(miscellaneousHead);
            return true;
        }
        return false;
    }

    public boolean delete(Integer miscHeadId) {
        MiscellaneousHead miscellaneousHeadEntity=getMiscHeadById(miscHeadId);
        if(miscellaneousHeadEntity!=null){
            miscellaneousHeadRepository.deleteById(miscHeadId);
            return true;
        }
        return false;
    }
}
