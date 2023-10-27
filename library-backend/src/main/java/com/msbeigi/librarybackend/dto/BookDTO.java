package com.msbeigi.librarybackend.dto;

import com.msbeigi.librarybackend.entity.Category;

import java.util.List;

public record BookDTO(
        String title,
        String author,
        String description,
        Integer copies,
        Integer copiesAvailable,
        String image,
        List<Category> categories
) {
}
