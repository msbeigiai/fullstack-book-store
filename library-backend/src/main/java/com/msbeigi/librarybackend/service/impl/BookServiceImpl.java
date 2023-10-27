package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.repository.BookRepository;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Category> getBookAllCategories(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return List.of();
    }
}
