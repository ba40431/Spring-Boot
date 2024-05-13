package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @PostMapping("/student")
    public String create(@RequestBody Student student){
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);

        return "create student";
    }

    @GetMapping("/student/{studentId}")
    public Student select(@PathVariable int studentId){
        // String sql = "SELECT * FROM student WHERE id = :studentId;";

        // Map<String, Object> map = new HashMap<>();
        // map.put("studentId", studentId);
        // StudentRowMapper rowMapper = new StudentRowMapper();

        // Student studentResult = namedParameterJdbcTemplate.queryForObject(sql, map, rowMapper); // 將資料庫查詢出來的數據，轉換成是 Java object
        
        // return "studentInfo: " + studentResult.getId() + "," + studentResult.getName();

        return studentService.getById(studentId);
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
