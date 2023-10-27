package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Category> getBookAllCategories(Long id);
}
