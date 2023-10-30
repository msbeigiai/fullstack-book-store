package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.model.Utils;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAll(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "sort", defaultValue = "id") String sortBy,
            @RequestParam(name = "category", required = false) Long categoryId,
            HttpServletRequest request) {

        if (categoryId == null || categoryId == 0) {
            return ResponseEntity.ok()
                    .body(
                            ResponseMapping.builder()
                                    .status(HttpStatus.OK)
                                    .dateTime(LocalDateTime.now())
                                    .next(Utils.createHttp(request.getServerName(),
                                            request.getServerPort(),
                                            request.getContextPath(), "api/v1/books")
                                            + "?page=" + (pageNumber + 1))
                                    .results(bookService.findAll(pageNumber, pageSize, sortBy))
                                    .build()
                    );
        } else {
            return ResponseEntity.ok()
                    .body(
                            ResponseMapping.builder()
                                    .status(HttpStatus.OK)
                                    .dateTime(LocalDateTime.now())
                                    .next(Utils.createHttp(request.getServerName(),
                                            request.getServerPort(),
                                            request.getContextPath(), "api/v1/books?category="+categoryId)
                                            + "?page=" + (pageNumber + 1)
                                    )
                                    .results(bookService.findBooksByCategoriesId(pageNumber, pageSize, sortBy, categoryId))
                                    .build()
                    );
        }

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

    /*@GetMapping("/categories/{id}/books")
    public ResponseEntity<?> getBookAllCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .body(
                        ResponseMapping.builder()
                                .status(HttpStatus.OK)
                                .dateTime(LocalDateTime.now())
                                .results(bookService.findBooksByCategoriesId(id))
                                .build()
                );
    }*/

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
