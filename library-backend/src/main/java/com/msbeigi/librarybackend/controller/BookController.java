package com.msbeigi.librarybackend.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.ResponseMapping;
import com.msbeigi.librarybackend.model.Utils;
import com.msbeigi.librarybackend.service.BookService;

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
            @RequestParam(name = "search", required = false) String search,
            HttpServletRequest request) {
        if (search != null && categoryId != null) {
            return ResponseEntity.ok().body(ResponseMapping.builder()
                    .status(HttpStatus.OK).dateTime(LocalDateTime.now())
                    .next(Utils.createHttp(request.getServerName(),
                            request.getServerPort(),
                            request.getContextPath(),
                            "api/vq/books?category=" + categoryId
                                    + "&search=" + search)
                            + "&page=" + (pageNumber + 1))
                    .results(bookService.getBooksByCategoryAndSearchIgnoreCase(
                            pageNumber, pageSize, sortBy, categoryId,
                            search))
                    .build());
        } else if (categoryId != null && categoryId != 0) {
            return ResponseEntity.ok().body(ResponseMapping.builder()
                    .status(HttpStatus.OK).dateTime(LocalDateTime.now())
                    .next(Utils.createHttp(request.getServerName(),
                            request.getServerPort(),
                            request.getContextPath(),
                            "api/v1/books?category=" + categoryId)
                            + "?page=" + (pageNumber + 1))
                    .results(bookService.findBooksByCategoriesId(pageNumber,
                            pageSize, sortBy, categoryId))
                    .build());
        } else if (search != null && search != "") {
            return ResponseEntity.ok().body(ResponseMapping.builder()
                    .status(HttpStatus.OK).dateTime(LocalDateTime.now())
                    .next(Utils.createHttp(request.getServerName(),
                            request.getServerPort(),
                            request.getContextPath(),
                            "api/v1/books?search=" + search) + "?page="
                            + (pageNumber + 1))
                    .results(bookService.findBooksByTitleIgnoreCase(pageNumber,
                            pageSize, sortBy, search))
                    .build());
        } else
            return ResponseEntity.ok().body(ResponseMapping.builder().status(HttpStatus.OK)
                    .dateTime(LocalDateTime.now())
                    .next(Utils.createHttp(request.getServerName(), request.getServerPort(),
                            request.getContextPath(), "api/v1/books") + "?page="
                            + (pageNumber + 1))
                    .results(bookService.findAll(pageNumber, pageSize, sortBy)).build());

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long bookId) {
        return ResponseEntity.ok().body(ResponseMapping.builder().status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .results(List.of(bookService.findById(bookId))).build());
    }

    /*
     * @GetMapping("/categories/{id}/books") public ResponseEntity<?>
     * getBookAllCategory(@PathVariable("id") Long id) { return ResponseEntity.ok()
     * .body(
     * ResponseMapping.builder() .status(HttpStatus.OK)
     * .dateTime(LocalDateTime.now())
     * .results(bookService.findBooksByCategoriesId(id)) .build() ); }
     */

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody BookRequestModel bookRequestModel) {
        bookService.addBook(bookRequestModel);
        return ResponseEntity.created(URI.create(""))
                .body(ResponseMapping.builder().status(HttpStatus.CREATED)
                        .dateTime(LocalDateTime.now())
                        .results(List.of("Book " + bookRequestModel.title()
                                + " has been added successfully."))
                        .build());
    }

}
