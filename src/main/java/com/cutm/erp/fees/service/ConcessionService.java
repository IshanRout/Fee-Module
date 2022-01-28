package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.Concession;
import com.cutm.erp.fees.entity.StudentDetail;
import com.cutm.erp.fees.repository.ConcessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcessionService {
    @Autowired
    private ConcessionRepository concessionRepository;
    @Autowired
    private StudentDetailService studentDetailService;

    public List<Concession> getAll() {
        return concessionRepository.findAll();
    }

    public Concession getConcessionByConcessionId(Integer concessionId) {
        return concessionRepository.getById(concessionId);
    }

    public List<Concession> getConcessionByStudentId(Integer studentId) {
        return concessionRepository.getConcessionByStudentId(studentId);
    }

    public boolean add(Concession concession) {
        Concession concessionEntity=new Concession();
        StudentDetail studentDetail=studentDetailService.getStudentById(concession.getStudentDetailId());
        if(studentDetail!=null){
            concessionEntity.setStudentDetail(studentDetail);
            concessionEntity.setSemester(concession.getSemester());
            concessionEntity.setAcademicYear(concession.getAcademicYear());
            concessionEntity.setConcessionType(concession.getConcessionType());
            concessionEntity.setAmount(concession.getAmount());
            concessionEntity.setGenerationDate(concession.getGenerationDate());
            concessionEntity.setAvailedDate(concession.getAvailedDate());
            concessionRepository.save(concessionEntity);
            return true;
        }
        return false;
    }

    public boolean update(Concession concession) {
        Concession concessionEntity=getConcessionByConcessionId(concession.getConcessionId());
        if(concessionEntity!=null){
            concessionEntity.setSemester(concession.getSemester());
            concessionEntity.setAcademicYear(concession.getAcademicYear());
            concessionEntity.setConcessionType(concession.getConcessionType());
            concessionEntity.setAmount(concession.getAmount());
            concessionEntity.setGenerationDate(concession.getGenerationDate());
            concessionEntity.setAvailedDate(concession.getAvailedDate());
            concessionRepository.save(concessionEntity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer concessionId) {
        Concession concessionEntity=getConcessionByConcessionId(concessionId);
        if (concessionEntity!=null){
            concessionRepository.deleteById(concessionId);
            return true;
        }
        return false;
    }
}
