package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Fine;
import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineService {
    @Autowired private FineRepository fineRepository;
    @Autowired private StudentDetailService studentDetailService;

    public List<Fine> getAll() {
        return fineRepository.findAll();
    }

    public Fine getFineById(Integer fineId) {
        return fineRepository.getById(fineId);
    }

    public List<Fine> getFineByStudentId(Integer studentId) {
        return fineRepository.getFineByStudentId(studentId);
    }

    public boolean add(Fine fine) {
        Fine fineEntity=new Fine();
        StudentDetail studentDetail=studentDetailService.getStudentById(fine.getStudentDetailId());
        if(studentDetail!=null){
            fineEntity.setStudentDetail(studentDetail);
            fineEntity.setFineType(fine.getFineType());
            fineEntity.setAmount(fine.getAmount());
            fineEntity.setDueDate(fine.getDueDate());
            fineEntity.setGenerationDate(fine.getGenerationDate());
            fineEntity.setPaidDate(fine.getPaidDate());
            fineEntity.setSemester(fine.getSemester());
            fineEntity.setAcademicYear(fine.getAcademicYear());
            fineEntity.setStatus(fine.getStatus());
            fineRepository.save(fineEntity);
            return true;
        }
        return false;
    }

    public boolean update(Fine fine) {
        Fine fineEntity=getFineById(fine.getFineId());
        if(fineEntity!=null){
            fineEntity.setFineType(fine.getFineType());
            fineEntity.setAmount(fine.getAmount());
            fineEntity.setDueDate(fine.getDueDate());
            fineEntity.setGenerationDate(fine.getGenerationDate());
            fineEntity.setPaidDate(fine.getPaidDate());
            fineEntity.setSemester(fine.getSemester());
            fineEntity.setAcademicYear(fine.getAcademicYear());
            fineEntity.setStatus(fine.getStatus());
            fineRepository.save(fineEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer fineId) {
        Fine fineEntity=getFineById(fineId);
        if(fineEntity!=null){
            fineRepository.deleteById(fineId);
            return true;
        }
        return false;
    }
}