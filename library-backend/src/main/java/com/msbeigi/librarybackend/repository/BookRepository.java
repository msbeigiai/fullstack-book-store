package com.msbeigi.librarybackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.msbeigi.librarybackend.entity.Book;

@Repository
public interface BookRepository
        extends PagingAndSortingRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    // List<Book> findByCategoriesId(Long categoryId);
    boolean existsById(Long bookId);

    Page<Book> findBooksByCategoriesId(Pageable page, Long categoryId);

    Page<Book> findBooksByTitleIgnoreCase(Pageable page, String title);
}
