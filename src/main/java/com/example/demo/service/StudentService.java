package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteStudent(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new IllegalStateException("Student with id not found");
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student=repository.findById(id).orElseThrow(() ->
                new IllegalStateException("Student with id "+id+" does not exists"));

        if (name!=null && !student.getName().equals(name) && !name.isEmpty()){
            student.setName(name);
        }

        if (email!=null && !email.equals(student.getEmail()) && !email.isEmpty()){
             if (repository.findAllByEmail(email).isPresent()){
                 throw new IllegalStateException(("email already exists"));
             }
             student.setEmail(email);
        }
    }
}
