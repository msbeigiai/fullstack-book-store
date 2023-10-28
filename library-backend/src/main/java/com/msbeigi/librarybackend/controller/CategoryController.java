package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.model.CategoryRequest;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.service.BookService;
import com.msbeigi.librarybackend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;
    private final BookService bookService;

    public CategoryController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(categoryService.findAll())
                                .build()
                );
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long categoryId) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(List.of(categoryService.findById(categoryId)))
                                .build()
                );
    }

    @GetMapping("/books/{bookId}/categories")
    public ResponseEntity<?> getAllCategoriesByBookId(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(categoryService.findCategoriesByBookId(bookId))
                                .build()
                );

    }

    @PostMapping("/books/{bookId}/categories")
    public ResponseEntity<?> addCategory(@PathVariable("bookId") Long bookId,
                                         @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.created(URI.create(""))
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.CREATED)
                                .dateTime(LocalDateTime.now())
                                .results(List.of(bookService.addCategory(bookId, categoryRequest)))
                                .build()
                );
    }

    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.created(URI.create(""))
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.CREATED)
                                .dateTime(LocalDateTime.now())
                                .results(List.of(categoryService.addCategory(categoryRequest)))
                                .build()
                );
    }






}
