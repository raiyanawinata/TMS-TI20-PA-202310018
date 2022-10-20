package com.ibik.academicservices.academicservices.ProgramStudy;
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
@RequestMapping("/api/programsStudy")
public class ProgramStudyController {

    @Autowired
    private ProgramsStudyServices programsStudyServices;

    @PostMapping
    public ProgramsStudy posProgramsStudy(@RequestBody ProgramsStudy programsStudy){
        return programsStudyServices.save(programsStudy);
    }

    @GetMapping
    public Iterable<ProgramsStudy> fetchProgramsStudy(){
        return programsStudyServices.findAll();
    }

    @GetMapping("/{id}")
    public ProgramsStudy fetchProgramsStudyById(@PathVariable("id") int id){
        return programsStudyServices.findOne(id);
    }

    @PutMapping
    public ProgramsStudy updateProgramsStudy(@RequestBody ProgramsStudy programsStudy){
        return programsStudyServices.save(programsStudy);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsStudyById(@PathVariable("id") int id){
        programsStudyServices.removeOne(id);
    }
    
}