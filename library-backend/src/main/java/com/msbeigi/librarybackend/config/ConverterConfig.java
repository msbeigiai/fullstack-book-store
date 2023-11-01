package com.msbeigi.librarybackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.msbeigi.librarybackend.converter.CategoryConverter;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.repository.CategoryRepository;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<String, Category> categoryConverter(CategoryRepository categoryRepository) {
        return new CategoryConverter(categoryRepository);
    }
}
