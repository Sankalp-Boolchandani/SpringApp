package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service            // annotation Service helps the annotation Autowired to point to the component which is to be instantiated
public class StudentService {
    public List<Student> getAllStudents() {
        return List.of(new Student(
                1L,
                "Sankalp",
                "sb@gmail.com",
                LocalDate.of(1999, Month.NOVEMBER, 18),
                24
        ));
    }
}
