package com.example.lover.model.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String address;
    @ManyToOne
    private Provider provider;
    @OneToMany
    private List<Service> services;
    private int totalTime;
    private int hourStart;
    private LocalDate dayStart;
    private int totalMoney;
    private String statusOrder;
    private String feedback;
}
