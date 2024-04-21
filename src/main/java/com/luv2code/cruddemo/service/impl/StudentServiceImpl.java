package com.luv2code.cruddemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.entity.dto.DeleteResultDTO;
import com.luv2code.cruddemo.entity.dto.UpdateResultDTO;
import com.luv2code.cruddemo.repository.StudentRepository;
import com.luv2code.cruddemo.service.StudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService  {

    // add Repo
    @Autowired
    private StudentRepository studentRepository;

    // find all student
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // create new student
    @Override
    public void createStudent(Student newStudent){
        studentRepository.save(newStudent);
    }

    // update student
    @Override
    public UpdateResultDTO updateStudent(Integer studentId,Student updateStudent){

          // Tìm kiếm đối tượng Student trong cơ sở dữ liệu với ID tương ứng
    Optional<Student> existingStudentOptional = studentRepository.findById(studentId);
    if (!existingStudentOptional.isPresent()) {
        return new UpdateResultDTO("Không tìm thấy sinh viên có ID " + studentId);
    }

     // Cập nhật thông tin của đối tượng Student
     Student existingStudent = existingStudentOptional.get();
     existingStudent.setFirstName(updateStudent.getFirstName());
     existingStudent.setLastName(updateStudent.getLastName());
     existingStudent.setEmail(updateStudent.getEmail());
 
     // Lưu đối tượng Student đã cập nhật vào cơ sở dữ liệu
     studentRepository.save(existingStudent);
     return new UpdateResultDTO("Đã cập nhập thành công");
} 

    // detele student
    public DeleteResultDTO deleteStudent(Integer studentId){
        // Tìm kiếm đối tượng Student trong cơ sở dữ liệu với ID tương ứng
    Optional<Student> existingStudentOptional = studentRepository.findById(studentId);
    if (!existingStudentOptional.isPresent()) {
        return new DeleteResultDTO("Không tìm thấy sinh viên có ID " + studentId);
    }

    studentRepository.deleteById(studentId);
    return new DeleteResultDTO("Đã xóa thành công");
    }
}


