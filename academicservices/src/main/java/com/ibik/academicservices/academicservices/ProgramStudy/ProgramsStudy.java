package com.ibik.academicservices.academicservices.ProgramStudy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="programsStudy")

    
    public class ProgramsStudy implements Serializable{
        private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @Column(length = 20)
        private String name;
    
        @Column(length = 20)
        private String description;

        @Column(length = 5)
        private String code;

        @Column(length = 11)
        private String program_id;

        @Column(length = 11)
        private String faculty_id;

        @Column(length = 11)
        private String department_id;
    
        @Column(nullable = false, columnDefinition = "TINYINT(1)")
        private boolean is_active;

        public ProgramsStudy(){}
    
        public ProgramsStudy(int id, String name, String description,
        String code,  String program_id,  String faculty_id,  String department_id, boolean is_active){
            this.id = id;
            this.name = name;
            this.description = description;
            this.is_active = is_active;
            this.code = code;
            this.program_id = program_id;
            this.faculty_id = faculty_id;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getProgram_id() {
            return program_id;
        }

        public void setProgram_id(String program_id) {
            this.program_id = program_id;
        }

        public String getFaculty_id() {
            return faculty_id;
        }

        public void setFaculty_id(String faculty_id) {
            this.faculty_id = faculty_id;
        }

        public String getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(String department_id) {
            this.department_id = department_id;
        }

        public boolean isIs_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }
}
