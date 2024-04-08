package com.fai.university.university.services;

import com.fai.university.university.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Integer id);
    void addNewStudent(Student student);
    void updateStudent();
    void deleteStudent(Integer id);
}
