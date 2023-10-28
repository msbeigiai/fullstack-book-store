package com.msbeigi.librarybackend.repository;

import com.msbeigi.librarybackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByCategoriesId(Long categoryId);
    boolean existsById(Long bookId);
    List<Book> findBooksByCategoriesId(Long categoryId);
}
