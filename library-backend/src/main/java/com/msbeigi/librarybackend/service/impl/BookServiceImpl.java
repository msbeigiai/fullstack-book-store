package com.msbeigi.librarybackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.hibernate.mapping.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.msbeigi.librarybackend.dto.DTOMapper;
import com.msbeigi.librarybackend.entity.Book;
import com.msbeigi.librarybackend.entity.Category;
import com.msbeigi.librarybackend.model.BookRequestModel;
import com.msbeigi.librarybackend.model.CategoryRequest;
import com.msbeigi.librarybackend.repository.BookRepository;
import com.msbeigi.librarybackend.repository.CategoryRepository;
import com.msbeigi.librarybackend.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final DTOMapper dtoMapper;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository,
            DTOMapper dtoMapper) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<Book> findAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        Page<Book> bookResult = bookRepository.findAll(paging);

        if (bookResult.hasContent()) {
            return bookResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Category> getBookAllCategories(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return book.getCategories();
    }

    @Override
    public void addBook(BookRequestModel bookRequestModel) {
        Book book = new Book(bookRequestModel.title(), bookRequestModel.author(),
                bookRequestModel.description(), bookRequestModel.copies(),
                bookRequestModel.copiesAvailable(), bookRequestModel.image());
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> findBooksByCategoriesId(Integer pageNumber, Integer pageSize, String sortBy,
            Long categoryId) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        if (!categoryRepository.existsById(categoryId))
            throw new RuntimeException("Category not found!");

        Page<Book> bookCategoryResult = bookRepository.findBooksByCategoriesId(paging, categoryId);
        if (bookCategoryResult.hasContent()) {
            return bookCategoryResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Category addCategory(Long bookId, CategoryRequest categoryRequest) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        boolean categoryExist = categoryRepository.findByNameIgnoreCase(categoryRequest.name()).isPresent();

        if (categoryExist) {
            Category category = categoryRepository.findByNameIgnoreCase(categoryRequest.name()).get();
            book.addCategory(category);
            bookRepository.save(book);
            return category;
        }

        Category newCategory = new Category(categoryRequest.name());
        book.addCategory(newCategory);
        return categoryRepository.save(newCategory);
    }

    @Override
    public List<Book> findBooksByTitleIgnoreCase(Integer pageNumber, Integer pageSize,
            String sortBy, String search) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Book> bookSearchResult = bookRepository.findByTitleContainingIgnoreCase(paging, search);
        if (bookSearchResult.hasContent()) {
            return bookSearchResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Book> getBooksByCategoryAndSearchIgnoreCase(Integer pageNumber, Integer pageSize, String sortBy,
            Long categoryId, String search) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        Page<Book> findBooksByCategoriesId = bookRepository.findBooksByCategoriesId(paging, categoryId);

        return findBooksByCategoriesId.stream().filter(b -> b.getTitle().contains(search)).toList();
    }

}
