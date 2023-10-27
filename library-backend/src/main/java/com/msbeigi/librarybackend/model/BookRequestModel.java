package com.msbeigi.librarybackend.model;

import com.msbeigi.librarybackend.entity.Category;

import java.util.List;

public record BookRequestModel(
        String title,
        String author,
        String description,
        Integer copies,
        Integer copiesAvailable,
        String image,
        List<Category> categories
) {
}
