package com.ibik.academicservices.academicservices.Student;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramsStudentServices {
    @Autowired
    private ProgramsStudentRepo programsStudentRepo;

    public ProgramsStudent save(ProgramsStudent programsStudent){
        return programsStudentRepo.save(programsStudent);
    }
    public ProgramsStudent findOne(int id){
        return programsStudentRepo.findById(id).get();
    }
    public Iterable<ProgramsStudent> findAll(){
        return programsStudentRepo.findAll();
    }
    public void removeOne(int id){
        programsStudentRepo.deleteById(id);
    }
}
