package com.msbeigi.librarybackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.msbeigi.librarybackend.entity.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {
    boolean existsById(Long bookId);

    Page<Book> findBooksByCategoriesId(Pageable page, Long categoryId);

    Page<Book> findByTitleContainingIgnoreCase(Pageable page, String title);
}
