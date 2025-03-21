package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id             // primary key attribute
    @SequenceGenerator(             // sequence generator is nothing but a kind of incremental value passed to the primary key
            name = "studentSequence",           // name in db table
            sequenceName = "studentSequence",           // reference name in in generated value
            allocationSize = 1              // value by which increment happens after every object creation
    )
    @GeneratedValue(            // helps the attribute in giving an auto value on object creation
            strategy = GenerationType.SEQUENCE,
            generator = "studentSequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient                  // this annotation means the value is there in our class but is not added to the DB.
    private Integer age;

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }               // helps sending dynamic age based on dob using transient annotation

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
