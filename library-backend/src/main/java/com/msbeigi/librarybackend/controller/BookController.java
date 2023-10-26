package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(books)
                                .build()
                );
    }
}
