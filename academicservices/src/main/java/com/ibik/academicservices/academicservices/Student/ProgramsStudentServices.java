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

    public ProgramsStudent update(ProgramsStudent programsStudent){
        ProgramsStudent result = findOne(programsStudent.getId());

        result.setFirstname(programsStudent.getFirstname());
        // result.setDepartment_id(programsStudent.getDepartment_id());
        result.setId(programsStudent.getId());
        result.setLastname(programsStudent.getLastname());
        result.setMiddlename(programsStudent.getMiddlename());
        result.setNpm(programsStudent.getNpm());
        // result.setProgram_id(programsStudent.getProgram_id());

        return result;
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

    public Iterable<ProgramsStudent> findProgramsStudentByName (String name){
        return programsStudentRepo.findProgramsStudentByName ("%" + name + "%");
    }
}
