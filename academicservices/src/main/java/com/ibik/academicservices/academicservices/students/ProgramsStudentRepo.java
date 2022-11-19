package com.ibik.academicservices.academicservices.students;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProgramsStudentRepo extends CrudRepository<ProgramsStudent, Integer> {
    @Query("SELECT a FORM ProgramsStudent a WHERE a.firstname LIKE :name OR a.middlename LIKE :name OR a.lastname LIKE :name OR a.npm LIKE :name")
    public Iterable<ProgramsStudent> findProgramsStudentByName (@PathParam("name") String name);
}
