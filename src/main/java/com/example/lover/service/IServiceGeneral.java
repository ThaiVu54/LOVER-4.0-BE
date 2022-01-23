package com.example.lover.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceGeneral<T>{
    Page<T> pageFindAll(Pageable pageable);
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
