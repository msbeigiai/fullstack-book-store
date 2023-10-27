package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.dto.BookDTO;
import com.msbeigi.librarybackend.dto.DTOMapper;
import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.repository.BookRepository;
import com.msbeigi.librarybackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final DTOMapper dtoMapper;

    public BookServiceImpl(BookRepository bookRepository, DTOMapper dtoMapper) {
        this.bookRepository = bookRepository;
        this.dtoMapper = dtoMapper;
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

    @Override
    public void addBook(BookRequestModel bookRequestModel) {
        Book book = new Book(
                bookRequestModel.title(),
                bookRequestModel.author(),
                bookRequestModel.description(),
                bookRequestModel.copies(),
                bookRequestModel.copiesAvailable(),
                bookRequestModel.image(),
                bookRequestModel.categories()

        );
        bookRepository.save(book);
    }
}
