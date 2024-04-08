package com.fai.university.university.dao;

import com.fai.university.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentReponsitory  extends JpaRepository<Student, Integer> {
}
