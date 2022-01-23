package com.example.lover.model.account;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int yearOfBirth;
    private String gender;
    private String city;
    private String country;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> images;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Service> services;
    private int height;
    private int weight;
    private String interests;
    private String description;
    private String requirements;
    private String linkFB;
    private int count;
    private int view;
    private boolean isActive;
    private boolean isConfirm;
    private boolean isVip;
    @OneToOne
    private User user;
}