package com.example.demo.config;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean           // bean makes sure that the below runs on the start of the server and creates object and saves in the DB
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{

            Student san=new Student(
                    "Sankalp",
                    "san@gmail.com",
                    LocalDate.of(1999, Month.NOVEMBER, 18)
            );

            Student viv=new Student(
                    "Vivek",
                    "viv@gmail.com",
                    LocalDate.of(2001, Month.MAY, 22)
            );

            repository.saveAll(List.of(san, viv));
        };
    }

}
