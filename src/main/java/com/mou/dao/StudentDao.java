package com.mou.dao;

import com.mou.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudents(Student student);
}
