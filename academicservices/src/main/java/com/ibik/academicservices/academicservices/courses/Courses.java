package com.ibik.academicservices.academicservices.courses;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.ibik.academicservices.academicservices.Student.ProgramsStudent;



@Entity
@Table(name = "course")
public class Courses {

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    @NotEmpty(message = "Name is Required")
    private String code;

    @Column(length = 11)
    @Min (value = 1, message = "Credit is Required")
    private int credit;

    @Column(length = 50)
    @NotEmpty(message = "Name is Required")
    private String name;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean is_active;
    @ManyToMany(mappedBy = "courses")
    private Set<ProgramsStudent> programsStudents;
    

    public Courses(){}

    public Courses(int id, @NotEmpty(message = "name is required") String name, @NotEmpty(message = "code is required")String code, 
    @Min(value = 1, message = "credit is require") int credit, boolean is_active, Set<ProgramsStudent> programsStudents){
        this.code = code;
        this.credit = credit;
        this.id = id;
        this.name = name;
        this.is_active = is_active;
        this.programsStudents = programsStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Set<ProgramsStudent> getProgramsStudents(){
        return programsStudents;
    }

    public void setProgramsStudents(Set<ProgramsStudent> programsStudents){
        this.programsStudents = programsStudents;
    }
}
