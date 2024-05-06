package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer {

    @Value("${count:10}") //如果想要「避免 application.properties 中找不到該 key，導致 Spring Boot 程式運行失敗」的狀況的話，那麼就可以在 @Value 中使用 :，在後面加上預設值，當找不到 key 時，就可以直接無縫接軌改成使用預設值來運行
    private int count;

    @Override
    public void print(String message){
        count --;
        System.out.println("HP 印表機: " + message);
        System.out.println("剩餘次數" + count);
    }
}
