package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
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

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long bookId) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(List.of(bookService.findById(bookId)))
                                .build()
                );
    }

    @GetMapping("/categories/{id}/books")
    public ResponseEntity<?> getBookAllCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(bookService.findBooksByCategoriesId(id))
                                .build()
                );
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody BookRequestModel bookRequestModel) {
        bookService.addBook(bookRequestModel);
        return ResponseEntity.created(URI.create(""))
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.CREATED)
                                .dateTime(LocalDateTime.now())
                                .results(List.of("Book " + bookRequestModel.title() + " has been added successfully."))
                                .build()
                );
    }
}
