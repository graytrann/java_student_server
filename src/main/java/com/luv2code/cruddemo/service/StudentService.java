package com.luv2code.cruddemo.service;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.entity.dto.DeleteResultDTO;
import com.luv2code.cruddemo.entity.dto.UpdateResultDTO;

public interface StudentService {
    List<Student> findAll();
    void createStudent(Student newStudent);
    UpdateResultDTO updateStudent(Integer studentId,Student updateStudent);
    DeleteResultDTO deleteStudent(Integer studentId);
}
