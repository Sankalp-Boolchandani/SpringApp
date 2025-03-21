package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service            // annotation Service helps the annotation Autowired to point to the component which is to be instantiated
public class StudentService {

    @Autowired
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void registerStudent(Student student) {
        Optional<Student> studentOptional=repository.findAllByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalCallerException("Email already exists");
        } else {
            repository.save(student);
        }
    }
}
