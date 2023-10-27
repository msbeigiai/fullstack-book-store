package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(bookService.findAll())
                                .build()
                );
    }

    @GetMapping("/{id}/categories")
    public ResponseEntity<?> getBookAllCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(bookService.getBookAllCategories(id))
                                .build()
                );
    }
}
