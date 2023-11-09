package com.msbeigi.librarybackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User  {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private String imageUrl;
    private Boolean enabled;
    private String role;

    public User() {
    }

    public User(String name, String email, String password,
                String imageUrl, Boolean enabled, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.enabled = enabled;
        this.role = role;
    }

}
