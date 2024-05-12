package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StudentController {
    
    @PostMapping("/student")
    public String create(@RequestBody Student student){
        return "create student";
    }

    @GetMapping("/student/{studentId}")
    public String create(@PathVariable int studentId){
        return "read student";
    }

    @PutMapping("student/{studentId}")
    public String update(@PathVariable int studentId, @RequestBody Student student) {
        return "update student";
    }

    @DeleteMapping("/student/{studentId}")
    public String delete(@PathVariable int studentId){
        return "delete student";
    }
}
