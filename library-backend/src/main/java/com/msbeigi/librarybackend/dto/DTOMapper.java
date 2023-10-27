package com.msbeigi.librarybackend.dto;

import com.msbeigi.librarybackend.entity.Book;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getCopies(),
                book.getCopiesAvailable(),
                book.getImage(),
                book.getCategories()
        );
    }
}
