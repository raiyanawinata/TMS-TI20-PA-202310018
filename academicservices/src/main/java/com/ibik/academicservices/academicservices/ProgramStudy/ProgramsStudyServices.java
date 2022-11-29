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
    public ProgramsStudy update(ProgramsStudy programsStudy){
        ProgramsStudy result = findOne(programsStudy.getId());

        result.setCode(programsStudy.getCode());
        //result.setDepartment_id(programsStudy.getDepartment_id());
        result.setDescription(programsStudy.getDescription());
        result.setDepartments(programsStudy.getDepartments());
        result.setPrograms(programsStudy.getPrograms());
        result.setName(programsStudy.getName());
        
        return result;
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
