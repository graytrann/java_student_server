package com.luv2code.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
