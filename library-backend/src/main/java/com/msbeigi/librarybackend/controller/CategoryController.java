package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
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
}
