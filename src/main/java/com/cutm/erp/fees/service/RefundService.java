package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Refund;
import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RefundService {
    @Autowired private RefundRepository refundRepository;
    @Autowired private StudentDetailService studentDetailService;
    public List<Refund> getAll() {
        return refundRepository.findAll();
    }

    public Refund getRefundById(Integer refundId) {
        return refundRepository.getById(refundId);
    }

    public List<Refund> getRefundByStudentId(Integer studentId) {
        return refundRepository.getRefundByStudentId(studentId);
    }

    public boolean add(Refund refund) {
        Refund refundEntity=new Refund();
        StudentDetail studentDetail=studentDetailService.getStudentById(refund.getStudentDetailId());
        if(studentDetail!=null){
            refundEntity.setStudentDetail(studentDetail);
            refundEntity.setRefundType(refund.getRefundType());
            refundEntity.setAmount(refund.getAmount());
            refundEntity.setCollectionDate(refund.getCollectionDate());
            refundEntity.setInitiationDate(refund.getInitiationDate());
            refundEntity.setSemester(refund.getSemester());
            refundEntity.setStatus(refund.getStatus());
            refundEntity.setAcademicYear(refund.getAcademicYear());
            refundRepository.save(refundEntity);
            return true;
        }
        return false;
    }

    public boolean update(Refund refund) {
        Refund refundEntity=getRefundById(refund.getRefundId());
        if(refundEntity!=null){
            refundEntity.setRefundType(refund.getRefundType());
            refundEntity.setAmount(refund.getAmount());
            refundEntity.setCollectionDate(refund.getCollectionDate());
            refundEntity.setInitiationDate(refund.getInitiationDate());
            refundEntity.setSemester(refund.getSemester());
            refundEntity.setStatus(refund.getStatus());
            refundEntity.setAcademicYear(refund.getAcademicYear());
            refundRepository.save(refundEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer refundId) {
        Refund refund=getRefundById(refundId);
        if(refund!=null){
            refundRepository.deleteById(refundId);
            return true;
        }
        return false;
    }
}