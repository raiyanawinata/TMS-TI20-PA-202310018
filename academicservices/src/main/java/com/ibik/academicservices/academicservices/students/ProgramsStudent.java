package com.ibik.academicservices.academicservices.students;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "programsStudent")
public class ProgramsStudent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (length = 15)
    @NotEmpty(message = "NPM IS REQUAIRED")
    private String npm;

    @Column (length = 10)
    @NotEmpty(message = "firstname IS REQUAIRED")
    private String firstname;

    @Column (length = 10)
    private String middlename;

    @Column (length = 10)
    @NotEmpty(message = "LASTNAME IS REQUAIRED")
    private String lastname;

    @Column (length = 11)
    @Min(value = 1, message = "program is required")
    private int program_id;

    @Column (length = 11)
    @Min(value = 1, message = "departmen is required")
    private int department_id;

    public ProgramsStudent(int id, String npm, String firstname, String middlename, String lastname, int program_id,
            int department_id) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.program_id = program_id;
        this.department_id = department_id;
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

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    
    
    
}
