package com.luv2code.cruddemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.entity.dto.DeleteResultDTO;
import com.luv2code.cruddemo.entity.dto.StudentInfoDTO;
import com.luv2code.cruddemo.entity.dto.StudentResDTO;
import com.luv2code.cruddemo.entity.dto.UpdateResultDTO;
import com.luv2code.cruddemo.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/v1/students")
public class StudentController {

    // private List<Student> theStudents;

    
    @Autowired
    private StudentService studentService;

    // @PostConstruct
    // public void loadData() {

    //     theStudents = new ArrayList<>();

    //     theStudents.add(new Student("Poornima", "Patel"));
    //     theStudents.add(new Student("Mario", "Rossi"));
    //     theStudents.add(new Student("Mary", "Smith"));
    // }

   

    // @GetMapping("/students/{studentId}")
    // public Student getStudent(@PathVariable int studentId) {


    //     if ( (studentId >= theStudents.size()) || (studentId < 0)) {
    //         throw new StudentNotFoundException("Student id not found - " + studentId);
    //     }

    //     return theStudents.get(studentId);
    // }

    // GET ALL STUDENT
    @GetMapping(path = "")
    public List<StudentInfoDTO> getAllStudent(){
        // List<Student> students = studentService.findAll();
        // List<StudentInfoDTO> convertedStudents = new ArrayList<>();
        // for (Student student : students) {
        //     convertedStudents.add(new StudentInfoDTO(student.getFirstName(), student.getLastName()));
        // }
        // return convertedStudents;
        return studentService.findAll()
        .stream()
        .map(item -> new StudentInfoDTO(item.getId(),item.getFirstName(), item.getLastName(),item.getEmail()))
        .collect(Collectors.toList());
    }

    // CREATE NEW STUDENT
    @PostMapping(path="")
    public String createNewStudent(@RequestBody StudentResDTO studentRequestDTO){

        String first_name = studentRequestDTO.getFirstName();
        String last_name = studentRequestDTO.getLastName();
        String email = studentRequestDTO.getEmail();
        
        Student newStudent = new Student(first_name,last_name,email);

        studentService.createStudent(newStudent);

        String responseText = "Đã tạo thành công student mới";
        return responseText;
    }

    // UPDATE STUDENT 
    @PutMapping(path="/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody StudentResDTO studentRequestDTO) {
       
        String firstName = studentRequestDTO.getFirstName();
        String lastName = studentRequestDTO.getLastName();
        String email = studentRequestDTO.getEmail();

        Student studentNewInfo = new Student(firstName,lastName,email);

        studentService.updateStudent(id,studentNewInfo);

        UpdateResultDTO updateResult = studentService.updateStudent(id, studentNewInfo);

        return updateResult.getMessage();

    }

    @DeleteMapping(path = "/{id}")
    public String deleteStudent(@PathVariable Integer id) {
 
        DeleteResultDTO deleteResult = studentService.deleteStudent(id);

        return deleteResult.getMessage();

    }

}
