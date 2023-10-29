package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.CategoryRequest;
import com.msbeigi.librarybackend.repository.BookRepository;
import com.msbeigi.librarybackend.repository.CategoryRepository;
import com.msbeigi.librarybackend.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> findCategoriesByBookId(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("book not found");
        }
        return categoryRepository.findCategoriesByBooksId(bookId);
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByNameIgnoreCase(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest.name());
        return categoryRepository.save(category);
    }
}
