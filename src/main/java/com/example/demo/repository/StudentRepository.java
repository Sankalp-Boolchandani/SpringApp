package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // what is does is creates an query in the DB that finds all the students with the given email
    // something like:= SELECT * FROM student where email=?
    Optional<Student> findAllByEmail(String email);

}
