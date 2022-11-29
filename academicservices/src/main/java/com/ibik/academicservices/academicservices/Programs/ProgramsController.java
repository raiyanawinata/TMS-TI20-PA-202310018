package com.ibik.academicservices.academicservices.Programs;

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
@RequestMapping("/api/programs")
public class ProgramsController {

    @Autowired
    private ProgramsServices programsServices;

    @PostMapping
    // public Programs posPrograms(@RequestBody Programs programs){
    //     return programsServices.save(programs);
    // }
    public ResponseEntity<ResponseData<Programs>> postPrograms(@Valid @RequestBody Programs programs, Errors errors){

        ResponseData<Programs> responseData = new ResponseData<>();
        if(errors.hasErrors()){
    for(ObjectError error : errors.getAllErrors()){
        // System.out.println(error.getDefaultMessage());
        responseData.getMessage().add(error.getDefaultMessage());
    }
    // throw new RuntimeException("Validation Error");
    responseData.setResult(false);
    responseData.setData(null);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
}
        responseData.setResult(true);
        List<Programs> value = new ArrayList<>();
        value.add(programsServices.save(programs));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
// return programsStudentServices.save(programsStudent);
}

    @GetMapping
    // public Iterable<Programs> fetchPrograms(){
    //     return programsServices.findAll();
    // }
    public ResponseEntity<ResponseData<Programs>>fetchPrograms(){
        ResponseData<Programs> responseData = new ResponseData<>();

        try {
            responseData.setResult(true);
            List<Programs> value = (List<Programs>)programsServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
           responseData.setResult(false);
           responseData.getMessage().add(e.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    // return programsStudentServices.findAll();

    @GetMapping("/{id}")
    // public Programs fetchProgramsById(@PathVariable("id") int id){
    //     return programsServices.findOne(id);
    // }
    public ResponseEntity<ResponseData<Programs>> fetchProgramsById(@PathVariable("id") int id){
        ResponseData<Programs> responseData = new ResponseData<>();
        // return programsStudentServices.findOne(id);
        try {
            responseData.setResult(true);
            List<Programs> value = new ArrayList<>();
            value.add(programsServices.findOne(id));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
         } catch (Exception e) {
                responseData.setResult(false);
                responseData.getMessage().add(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
             }
            }


    @PutMapping
    // public Programs updatePrograms(@RequestBody Programs programs){
    //     return programsServices.save(programs);
    public ResponseEntity<ResponseData<Programs>> updatePrograms(@Valid @RequestBody Programs programs, Errors errors){
        ResponseData<Programs> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
        }
        try {
            responseData.setResult(true);
        List<Programs> value = new ArrayList<>();
        value.add(programsServices.update(programs));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);

        } catch (Exception e) {
            responseData.getMessage().add("Id is required");
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            
        }
    }

    @DeleteMapping("/{id}")
    // public void deleteProgramsById(@PathVariable("id") int id){
    //     programsServices.removeOne(id);
    // }
    public ResponseEntity<ResponseData<Void>> deleteProgramsById(@PathVariable("id") int id){
        ResponseData<Void> responseData = new ResponseData<>();

        try {
            programsServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());;

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    // programsStudentServices.removeOne(id);
}
}
    
