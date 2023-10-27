package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.dto.BookDTO;
import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.BookRequestModel;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Category> getBookAllCategories(Long id);

    void addBook(BookRequestModel bookRequestModel);
}
