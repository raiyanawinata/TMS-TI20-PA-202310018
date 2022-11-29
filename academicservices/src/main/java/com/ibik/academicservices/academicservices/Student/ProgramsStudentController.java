package com.ibik.academicservices.academicservices.Student;
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
import com.ibik.academicservices.academicservices.dto.SearchData;

@RestController
@RequestMapping("/api/programsStudent")
public class ProgramsStudentController {

    @Autowired
    private ProgramsStudentServices programsStudentServices;

    @PostMapping
    
    // public ProgramsStudent posProgramsStudent(@RequestBody ProgramsStudent programsStudent){
        // public ProgramsStudent posProgramsStudent(@Valid @RequestBody ProgramsStudent programsStudent, Errors errors){
            public ResponseEntity<ResponseData<ProgramsStudent>> postProgramsStudent(@Valid @RequestBody ProgramsStudent programsStudent, Errors errors){

                ResponseData<ProgramsStudent> responseData = new ResponseData<>();
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
        List<ProgramsStudent> value = new ArrayList<>();
        value.add(programsStudentServices.save(programsStudent));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
        // return programsStudentServices.save(programsStudent);
    }

    @GetMapping
    // public Iterable<ProgramsStudent> fetchProgramsStudent(){
        public ResponseEntity<ResponseData<ProgramsStudent>>fetchProgramsStudent(){
            ResponseData<ProgramsStudent> responseData = new ResponseData<>();

            try {
                responseData.setResult(true);
                List<ProgramsStudent> value = (List<ProgramsStudent>)programsStudentServices.findAll();
                responseData.setData(value);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
               responseData.setResult(false);
               responseData.getMessage().add(e.getMessage());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        // return programsStudentServices.findAll();
    }

    @GetMapping("/{id}")
    // public ProgramsStudent fetchProgramsStudentById(@PathVariable("id") int id){
        public ResponseEntity<ResponseData<ProgramsStudent>> fetchProgramsStudentById(@PathVariable("id") int id){
            ResponseData<ProgramsStudent> responseData = new ResponseData<>();
            // return programsStudentServices.findOne(id);
            try {
                responseData.setResult(true);
                List<ProgramsStudent> value = new ArrayList<>();
                value.add(programsStudentServices.findOne(id));
                responseData.setData(value);
                return ResponseEntity.ok(responseData);
             } catch (Exception e) {
                    responseData.setResult(false);
                    responseData.getMessage().add(e.getMessage());
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
                 }
    }

    @PutMapping
    // public ProgramsStudent updateProgramsStudent(@RequestBody ProgramsStudent programsStudent){
        public ResponseEntity<ResponseData<ProgramsStudent>> updateProgramsStudent(@Valid @RequestBody ProgramsStudent programsStudent, Errors errors){
            ResponseData<ProgramsStudent> responseData = new ResponseData<>();
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
            List<ProgramsStudent> value = new ArrayList<>();
            value.add(programsStudentServices.update(programsStudent));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);

            } catch (Exception e) {
                responseData.getMessage().add("Id is required");
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
                
            }
            
        // return programsStudentServices.save(programsStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Void>> deleteStudentsById(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();
        try {
            programsStudentServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Remove");

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    
        @PostMapping("/search")
    public ResponseEntity<ResponseData<ProgramsStudent>> getProgramsStudentByName(@RequestBody SearchData searchData) {
    ResponseData<ProgramsStudent> responseData = new ResponseData<>();
        try {
            Iterable<ProgramsStudent> value = programsStudentServices.findProgramsStudentByName(searchData.getSearchKey());
            responseData.setResult(true);
            responseData.getMessage();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.getMessage().add(e.getMessage());
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }
    
}
