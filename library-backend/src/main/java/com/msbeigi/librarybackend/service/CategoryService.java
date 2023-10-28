package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long categoryId);

    List<Category> findCategoriesByBookId(Long bookId);

    Category findByName(String categoryName);

    Category addCategory(CategoryRequest categoryRequest);
}
