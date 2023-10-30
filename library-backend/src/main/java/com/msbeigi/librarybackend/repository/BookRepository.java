package com.msbeigi.librarybackend.repository;

import com.msbeigi.librarybackend.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
//    List<Book> findByCategoriesId(Long categoryId);
    boolean existsById(Long bookId);
    Page<Book> findBooksByCategoriesId(Pageable page, Long categoryId);
}
