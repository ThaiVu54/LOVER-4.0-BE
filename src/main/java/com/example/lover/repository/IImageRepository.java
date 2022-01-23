package com.example.lover.repository;

import com.example.lover.model.account.Image;
import com.example.lover.model.account.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
    Iterable<Image> findAllByProvider (Provider provider);
}
