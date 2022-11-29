package com.ibik.academicservices.academicservices.ProgramStudy;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.academicservices.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/programsStudy")
public class ProgramStudyController {

    @Autowired
    private ProgramsStudyServices programsStudyServices;

    @PostMapping
    // public ProgramsStudy posProgramsStudy(@RequestBody ProgramsStudy
    // programsStudy){
    // return programsStudyServices.save(programsStudy);
    // }
    public ResponseEntity<ResponseData<ProgramsStudy>> postPrograms(@Valid @RequestBody ProgramsStudy programsStudy,
            Errors errors) {

        ResponseData<ProgramsStudy> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                // System.out.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage());
            }
            // throw new RuntimeException("Validation Error");
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setResult(true);
        List<ProgramsStudy> value = new ArrayList<>();
        value.add(programsStudyServices.save(programsStudy));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    // public Iterable<ProgramsStudy> fetchProgramsStudy(){
    // return programsStudyServices.findAll();
    // }
    public ResponseEntity<ResponseData<ProgramsStudy>> fetchProgramsStudy() {
        ResponseData<ProgramsStudy> responseData = new ResponseData<>();

        try {
            responseData.setResult(true);
            Iterable<ProgramsStudy> value = programsStudyServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    // public ProgramsStudy fetchProgramsStudyById(@PathVariable("id") int id){
    // return programsStudyServices.findOne(id);
    // }
    public ResponseEntity<ResponseData<ProgramsStudy>> fetchProgramsById(@PathVariable("id") int id) {
        ResponseData<ProgramsStudy> responseData = new ResponseData<>();
        // return programsStudentServices.findOne(id);
        try {
            responseData.setResult(true);
            List<ProgramsStudy> value = new ArrayList<>();
            value.add(programsStudyServices.findOne(id));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    // public ProgramsStudy updateProgramsStudy(@RequestBody ProgramsStudy
    // programsStudy){
    // return programsStudyServices.save(programsStudy);
    // }
    public ResponseEntity<ResponseData<ProgramsStudy>> updateProgramsStudy(
            @Valid @RequestBody ProgramsStudy programsStudy, Errors errors) {
        ResponseData<ProgramsStudy> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
        }
        try {
            responseData.setResult(true);
            List<ProgramsStudy> value = new ArrayList<>();
            value.add(programsStudyServices.update(programsStudy));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);

        } catch (Exception e) {
            responseData.getMessage().add("Id is required");
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }
    }

    @DeleteMapping("/{id}")
    // public void deleteProgramsStudyById(@PathVariable("id") int id){
    // programsStudyServices.removeOne(id);
    // }
    public ResponseEntity<ResponseData<Void>> deleteProgramsStudyById(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();

        try {
            programsStudyServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());
            ;

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
}
