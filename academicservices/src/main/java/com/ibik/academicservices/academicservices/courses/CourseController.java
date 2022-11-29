package com.ibik.academicservices.academicservices.courses;

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

import com.ibik.academicservices.academicservices.Student.ProgramsStudent;
import com.ibik.academicservices.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @PostMapping
    public ResponseEntity<ResponseData<Courses>> postCourses(@Valid @RequestBody Courses courses, Errors errors){

        ResponseData<Courses> responseData = new ResponseData<>();
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
List<Courses> value = new ArrayList<>();
value.add(CourseServices.save(courses));
responseData.setData(value);
return ResponseEntity.ok(responseData);
// return programsStudentServices.save(programsStudent);
}
    // public Courses posCourses(@RequestBody Courses courses){
    //     return courseServices.save(courses);

    // }

    @GetMapping
    // public Iterable<Courses> fetchCourses(){
    //     return courseServices.findAll();
    // }
    public ResponseEntity<ResponseData<Courses>> fetchCourses(){
        ResponseData<Courses> responseData = new ResponseData<>();
        // return programsStudentServices.findOne(id);
        try {
            responseData.setResult(true);
            List<Courses> value = (List<Courses>) CourseServices.findAll();
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
         } catch (Exception e) {
                responseData.setResult(false);
                responseData.getMessage().add(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
             }
            }

    @GetMapping("/{id}")
    // public Courses fetchCourseById(@PathVariable("id") int id){
    //     return courseServices.findOne(id);
    // }
    public ResponseEntity<ResponseData<Courses>> fetchCoursesById(@PathVariable("id") int id){
        ResponseData<Courses> responseData = new ResponseData<>();
        // return programsStudentServices.findOne(id);
        try {
            responseData.setResult(true);
            List<Courses> value = new ArrayList<>();
            value.add(courseServices.findOne(id));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
         } catch (Exception e) {
                responseData.setResult(false);
                responseData.getMessage().add(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
             }
            }

    @PutMapping
    // public Courses updateCourses(@RequestBody Courses courses){
    //     return CourseServices.save(courses);
    // }
    public ResponseEntity<ResponseData<Courses>> updateCourses(@Valid @RequestBody Courses courses, Errors errors){
        ResponseData<Courses> responseData = new ResponseData<>();
        if (courses.getId() != 0){
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
        }
       
            responseData.setResult(true);
        List<Courses> value = new ArrayList<>();
        value.add(courseServices.save(courses));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);

    }else{
        responseData.getMessage().add("id is required");
        responseData.setResult(false);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
       
    }

    @DeleteMapping("/{id}")
    // public void deleteCourseById(@PathVariable("id") int id){
    //     courseServices.removeOne(id);
    // }
    public ResponseEntity<ResponseData<Void>> deleteCoursesById(@PathVariable("id") int id){
        ResponseData<Void> responseData = new ResponseData<>();

        try {
            courseServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setResult(false);
            responseData.getMessage().add(e.getMessage());;

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
}
}
