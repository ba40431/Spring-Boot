package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable int bookId){
        Book book = bookService.getBookById(bookId);

        if(book != null){
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
