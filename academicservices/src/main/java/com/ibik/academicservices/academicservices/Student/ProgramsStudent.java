package com.ibik.academicservices.academicservices.Student;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="programsStudent")
public class ProgramsStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 15)
    private String npm;

    @Column(length = 10)
    private String firstname;

    @Column(length = 10)
    private String middlename;

    @Column(length = 10)
    private String lastname;

    @Column(length = 11)
    private String program_id;

    @Column(length = 11)
    private String department_id;

    public ProgramsStudent(){}

    public ProgramsStudent(int id, String npm, String firstname,
    String middlename, String lastname, String program_id, String department_id){
        
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.program_id = program_id;
        this.department_id = department_id;
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



    public String getProgram_id() {
        return program_id;
    }



    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }



    public String getDepartment_id() {
        return department_id;
    }



    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    
}
