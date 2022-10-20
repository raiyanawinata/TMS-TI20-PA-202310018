package com.ibik.academicservices.academicservices.ProgramStudy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramsStudyServices {
    @Autowired
    private ProgramsStudyRepo programsStudyRepo;

    public ProgramsStudy save(ProgramsStudy programsStudy){
        return programsStudyRepo.save(programsStudy);
    }
    public ProgramsStudy findOne(int id){
        return programsStudyRepo.findById(id).get();
    }
    public Iterable<ProgramsStudy> findAll(){
        return programsStudyRepo.findAll();
    }
    public void removeOne(int id){
        programsStudyRepo.deleteById(id);
    }
}
