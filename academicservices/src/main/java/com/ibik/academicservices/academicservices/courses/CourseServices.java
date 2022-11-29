package com.ibik.academicservices.academicservices.courses;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseServices {
    
    @Autowired
    private static  CourseRepo courseRepo;

    public static  Courses save(Courses courses){
        return courseRepo.save(courses);
    }

    public Courses findOne(int id){
        return courseRepo.findById(id).get();
    }
  
    public static Iterable<Courses>findAll(){
        return courseRepo.findAll();
    }

    public void removeOne(int id){
        courseRepo.deleteById(id);
    }
}
