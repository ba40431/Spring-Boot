package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookService implements BookServiceInterface {
    
    @Autowired
    private BookDto bookDto;
    
    @Override
    public Book getBookById(int bookId){
        return bookDto.getBookById(bookId);
    }
}
