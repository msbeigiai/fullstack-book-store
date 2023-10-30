package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.CategoryRequest;

import java.util.List;

public interface BookService {
    List<Category> getBookAllCategories(Long id);
    void addBook(BookRequestModel bookRequestModel);
    Book findById(Long bookId);
    List<Book> findBooksByCategoriesId(Integer pageNumber, Integer pageSize, String sortBy, Long categoryId);
    List<Book> findAll(Integer pageNumber, Integer pageSize, String sortBy);
    Category addCategory(Long bookId, CategoryRequest categoryRequest);
}
