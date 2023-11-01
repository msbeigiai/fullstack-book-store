package com.msbeigi.librarybackend.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    private final CategoryRepository categoryRepository;

    public CategoryConverter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Nullable
    public Category convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(source);
        return categoryRepository.findById(id).orElse(null);
    }

    /*
     * @Override
     * public boolean supports(Class<?> sourceType, Class<?> targetType) {
     * return sourceType.equals(String.class) && targetType.equals(Category.class);
     * 
     * }
     */
}
