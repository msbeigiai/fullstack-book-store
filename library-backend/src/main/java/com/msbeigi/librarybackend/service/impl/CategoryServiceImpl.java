package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.repository.CategoryRepository;
import com.msbeigi.librarybackend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
