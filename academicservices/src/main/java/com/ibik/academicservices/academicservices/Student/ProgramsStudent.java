package com.ibik.academicservices.academicservices.Student;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.ibik.academicservices.academicservices.ProgramStudy.ProgramsStudy;
import com.ibik.academicservices.academicservices.Programs.Programs;
import com.ibik.academicservices.academicservices.courses.Courses;





@Entity
@Table(name="programsStudent")
public class ProgramsStudent implements Serializable {

    private static final long serialVersionUID = 1L;
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 15)
    @NotEmpty(message = "NPM is required")
    private String npm;

    @Column(length = 30)
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(length = 15)
    @NotEmpty(message = "birthdate is required")
    private String birthdate;

    @Column(length = 10)
    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @Column(length = 10)
    private String middlename;

    @Column(length = 10)
    @NotEmpty(message = "Lastname is required")
    private String lastname;

    @ManyToOne
    @JoinColumn( name = "program_id")
    private Programs programs;

    @ManyToOne
    @JoinColumn( name = "department_id")
    private ProgramsStudy programsStudy;

    // @Column(length = 11)
    // @Min(value = 1, message = "Program is required")
    // private String program_id;

    // @Column(length = 11)
    // @Min(value = 1, message = "Department is required")
    // private String department_id;
    @ManyToMany
    @JoinTable(
        name = "student_rel_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Courses> courses;
    
    
    public ProgramsStudent(){}

    public ProgramsStudent(int id, String npm, String firstname,
    String middlename, String lastname, Programs programs , ProgramsStudy programsStudy, String birthdate, String email){
        // String program_id, String department_id
        
      
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
       
        this.lastname = lastname;
        this.email =email;
        this.birthdate = birthdate;
        // this.program_id = program_id;
        // this.department_id = department_id;
        this.programs = programs;
        this.programsStudy = programsStudy;
       
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }



    public String getNpm() {
        return npm;
    }



    public void setNpm(String npm) {
        this.npm = npm;
    }



    public String getFirstname() {
        return firstname;
    }



    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public String getMiddlename() {
        return middlename;
    }



    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Programs getPrograms(){
        return programs;
    }
    public void setPrograms(Programs programs){
        this.programs = programs;
    }

    public ProgramsStudy getProgramsStudy(){
        return programsStudy;
    }
    public void setProgramsStudy(ProgramsStudy programsStudy){
        this.programsStudy = programsStudy;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }


    public ProgramsStudent update(@Valid ProgramsStudent programsStudent) {
        return null;
    }

    
}
