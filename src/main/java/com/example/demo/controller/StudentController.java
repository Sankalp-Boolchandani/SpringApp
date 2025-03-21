package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="v1/api/")
public class StudentController {

    @Autowired              // annotation autowired means that the associated component will be instantiated automatically on the start of the server
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getStudents")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("registerStudent")
    public void registerStudent(@RequestBody Student student){
        studentService.registerStudent(student);
    }

    @DeleteMapping(path="deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path="updateStudent/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}
