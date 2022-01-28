package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.FeePaymentInfo;
import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.FeePaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeePaymentInfoService {
    @Autowired private FeePaymentInfoRepository feePaymentInfoRepository;
    @Autowired private StudentDetailService studentDetailService;

    public List<FeePaymentInfo> getAll() {
        return feePaymentInfoRepository.findAll();
    }

    public FeePaymentInfo getFeePaymentInfoById(Integer feePaymentInfoId) {
        return feePaymentInfoRepository.getById(feePaymentInfoId);
    }

    public List<FeePaymentInfo> getFeePaymentInfoByStudentId(Integer studentId) {
        return feePaymentInfoRepository.getFeePaymentInfoByStudentId(studentId);
    }

    public boolean add(FeePaymentInfo feePaymentInfo) {
        FeePaymentInfo feePaymentInfoEntity=new FeePaymentInfo();
        StudentDetail studentDetail=studentDetailService.getStudentById(feePaymentInfo.getStudentDetailId());
        if(studentDetail!=null){
            feePaymentInfoEntity.setStudentDetail(studentDetail);
            feePaymentInfoEntity.setFeeHead(feePaymentInfo.getFeeHead());
            feePaymentInfoEntity.setTimeOfPayment(feePaymentInfo.getTimeOfPayment());
            feePaymentInfoEntity.setAmount(feePaymentInfo.getAmount());
            feePaymentInfoEntity.setEnteredBy(feePaymentInfo.getEnteredBy());
            feePaymentInfoEntity.setTransactionId(feePaymentInfo.getTransactionId());
            feePaymentInfoEntity.setTransactionType(feePaymentInfo.getTransactionType());
            feePaymentInfoEntity.setAcademicYear(feePaymentInfo.getAcademicYear());
            feePaymentInfoRepository.save(feePaymentInfoEntity);
            return true;
        }
        return false;
    }

    public boolean update(FeePaymentInfo feePaymentInfo) {
        FeePaymentInfo feePaymentInfoEntity=getFeePaymentInfoById(feePaymentInfo.getFeePaymentId());
        if(feePaymentInfoEntity!=null){
            feePaymentInfoEntity.setFeeHead(feePaymentInfo.getFeeHead());
            feePaymentInfoEntity.setTimeOfPayment(feePaymentInfo.getTimeOfPayment());
            feePaymentInfoEntity.setAmount(feePaymentInfo.getAmount());
            feePaymentInfoEntity.setEnteredBy(feePaymentInfo.getEnteredBy());
            feePaymentInfoEntity.setTransactionId(feePaymentInfo.getTransactionId());
            feePaymentInfoEntity.setTransactionType(feePaymentInfo.getTransactionType());
            feePaymentInfoEntity.setAcademicYear(feePaymentInfo.getAcademicYear());
            feePaymentInfoRepository.save(feePaymentInfoEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer feePaymentInfoId) {
        FeePaymentInfo feePaymentInfoEntity=getFeePaymentInfoById(feePaymentInfoId);
        if(feePaymentInfoEntity!=null){
            feePaymentInfoRepository.deleteById(feePaymentInfoId);
            return true;
        }
        return false;
    }
}