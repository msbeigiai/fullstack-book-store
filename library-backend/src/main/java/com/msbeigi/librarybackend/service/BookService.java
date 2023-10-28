package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.CategoryRequest;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Category> getBookAllCategories(Long id);
    void addBook(BookRequestModel bookRequestModel);
    Book findById(Long bookId);
    List<Book> findBooksByCategoriesId(Long categoryId);

    Category addCategory(Long bookId, CategoryRequest categoryRequest);
}
