package com.rmnlcn.Hibernate_JPA_CRUD_student.daos;

import com.rmnlcn.Hibernate_JPA_CRUD_student.entities.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}
