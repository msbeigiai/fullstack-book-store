package com.msbeigi.librarybackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "book")
@NoArgsConstructor
@Data
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "copies")
    private Integer copies;

    @Column(name = "copies_available")
    private Integer copiesAvailable;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "book_categories",
            joinColumns = {
                    @JoinColumn(name = "book_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")
            }
    )
    List<Category> categories;

    public Book(String title, String author,
                String description, Integer copies,
                Integer copiesAvailable, String image,
                List<Category> categories) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.copies = copies;
        this.copiesAvailable = copiesAvailable;
        this.image = image;
        this.categories = categories;
    }

    public void addCategories(Category category) {
        if (categories == null) {
            categories = new ArrayList<>();
            categories.add(category);
        }
    }
}
























