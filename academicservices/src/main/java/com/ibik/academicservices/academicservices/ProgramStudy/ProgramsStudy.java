package com.ibik.academicservices.academicservices.ProgramStudy;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.academicservices.academicservices.Programs.Programs;



@Entity
@Table(name="programsStudy")

    
    public class ProgramsStudy implements Serializable{
        private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @Column(length = 20)
        @NotEmpty(message = "Name is required")
        private String name;
    
        @Column(length = 20)
        @NotEmpty(message = "Description is required")
        private String description;

        @Column(length = 5)
        @NotEmpty(message = "Code is required")
        private String code;

        @ManyToOne
        @JoinColumn(name = "program_id")
        private Programs programs;

        // @Column(length = 11)
        // @NotEmpty(message = "ProgramId is required")
        // private String program_id;
        
        @OneToMany
        @JoinColumn(name = "faculty_id")
        private Set<ProgramsStudy> Departments;

        // @Column(length = 11)
        // @NotEmpty(message = "Faculty_id is required")
        // private String faculty_id;

        // @Column(length = 11)
        // @NotEmpty(message = "Department_id is required")
        // private String department_id;

        
        @Column(nullable = false, columnDefinition = "TINYINT(1)")
        private boolean is_active;

        public ProgramsStudy(int id, @NotEmpty(message = "Name is required") String name,
                @NotEmpty(message = "Description is required") String description,
                @NotEmpty(message = "Code is required") String code, Programs programs ,boolean is_active, Set<ProgramsStudy> Departments) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.code = code;
            this.is_active = is_active;
            this.Departments = Departments;
            this.programs = programs;
        }

        public ProgramsStudy(){}
    
        // public ProgramsStudy(int id, String name, String description,
        // String code, String faculty_id, String department_id, boolean is_active){
        //     this.id = id;
        //     this.name = name;
        //     this.description = description;
        //     this.is_active = is_active;
        //     this.code = code;
        //     this.programs = programs;
        //     this.faculty_id = faculty_id;
        //     this.department_id = department_id;
        // }
    

        public ProgramsStudy(Programs programs) {
            
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

       
        // public Programs getProgram_id() {
        //     return programs;
        // }

        // public void setProgram_id(Programs programs) {
        //     this.programs = programs;
        // }

        // public String getFaculty_id() {
        //     return faculty_id;
        // }

        // public void setFaculty_id(String faculty_id) {
        //     this.faculty_id = faculty_id;
        // }

        // public String getDepartment_id() {
        //     return department_id;
        // }

        // public void setDepartment_id(String department_id) {
        //     this.department_id = department_id;
        // }

        public boolean isIs_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }

        public Programs getPrograms() {
            return programs;
        }

        public void setPrograms(Programs programs) {
            this.programs = programs;
        }

        public Set<ProgramsStudy> getDepartments() {
            return Departments;
        }

        public void setDepartments(Set<ProgramsStudy> departments) {
            Departments = departments;
        }
}
