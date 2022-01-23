package com.example.lover.model.account;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private int phoneNumber;
    private String avatar;
    private LocalDate joinDate;
    private Boolean isBlock;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String encode, String avatar) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.avatar = avatar;
    }

    public User() {

    }
}
