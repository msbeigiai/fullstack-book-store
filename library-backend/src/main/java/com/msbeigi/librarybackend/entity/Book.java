package com.msbeigi.librarybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "category")
    private String category;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
}
























