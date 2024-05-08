package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;
    
    @RequestMapping("/test")
    public String test() {
        printer.print("Hello World !");
        // System.out.println("Hi!");
        return "Hello World!";
    }

    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);

        return store;
    }

    @RequestMapping("/user")
    public Student user() {
        Student student = new Student();
        student.setName("Judy");
        return student;
    }

}
