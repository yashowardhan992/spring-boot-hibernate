package com.springRest.demo.rest;


import com.springRest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    // define @PostController to load the student data.

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Micheal","Scott"));
        theStudents.add(new Student("Joe","Benett"));
        theStudents.add(new Student("Dwight","Schrute"));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;

    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //check the student id against the list size
        if(studentId>=theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }




}
