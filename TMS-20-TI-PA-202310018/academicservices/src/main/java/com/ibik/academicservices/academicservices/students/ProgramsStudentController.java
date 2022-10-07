package com.ibik.academicservices.academicservices.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ProgramsStudent")
public class ProgramsStudentController {
    
    @Autowired
    private ProgramsStudentServices programsStudentServices;

    @PostMapping
    public ProgramsStudent posProgramsStudent(@RequestBody ProgramsStudent programsStudent){
        return programsStudentServices.save(programsStudent);
    }

    @GetMapping
    public Iterable<ProgramsStudent> fetchPrograms(){
        return programsStudentServices.findAll();
    }

    @GetMapping("/{id}")
    public ProgramsStudent fetchProgramsStudentById(@PathVariable("id") int id){
        return programsStudentServices.findOne(id);
    }

    @PutMapping
    public ProgramsStudent updateProgramsStudent(@RequestBody ProgramsStudent programsStudent){
        return programsStudentServices.save(programsStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsById(@PathVariable("id") int id){
       programsStudentServices.removeOne(id);
    }
}
