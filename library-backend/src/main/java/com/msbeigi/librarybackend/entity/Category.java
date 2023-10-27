package com.msbeigi.librarybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "category_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "categories")
//    private List<Book> books;

}
