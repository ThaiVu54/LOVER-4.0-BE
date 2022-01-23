package com.example.lover.repository;

import com.example.lover.model.account.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Long> {
    @Query(value = "SELECT p from provider p order by p.view = Desc ",nativeQuery = true)
    List<Provider> top6Provider();

    Page<Provider>findAllByNameContaining(String name, Pageable pageable);
}
