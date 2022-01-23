package com.example.lover.repository;

import com.example.lover.model.account.Services;
import com.example.lover.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IServiceRepository extends JpaRepository<Services, Long> {
    Iterable<Services>findAllByUser(User user);
}
