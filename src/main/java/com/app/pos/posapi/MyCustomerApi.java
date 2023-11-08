package com.app.pos.posapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyCustomerApi {

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents(){
        
        List<Student> students= new ArrayList<>();
        for(int i=0;i<10;i++){
            students.add(new Student(i, "Name"+i));
        }

        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable int id){
        
        List<Student> students= new ArrayList<>();
        for(int i=0;i<10;i++){
            students.add(new Student(i, "Name"+i));
        }

        Student stu = students.stream().filter(x->{
            if (x.getId()==id){
                return true;
            } else {
                return false;
            }
        }).findFirst().orElse(new Student(0, "none-0"));

        return new ResponseEntity<Student>(stu,HttpStatus.OK);
    }

}