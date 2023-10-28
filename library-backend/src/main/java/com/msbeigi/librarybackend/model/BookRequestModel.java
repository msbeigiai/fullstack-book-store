package com.msbeigi.librarybackend.model;

public record BookRequestModel(
        String title,
        String author,
        String description,
        Integer copies,
        Integer copiesAvailable,
        String image
) {
}
