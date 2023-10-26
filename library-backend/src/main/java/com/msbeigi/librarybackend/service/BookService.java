package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
