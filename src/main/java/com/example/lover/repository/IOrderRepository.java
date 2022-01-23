package com.example.lover.repository;

import com.example.lover.model.account.Order;
import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select o from Order o where o.statusOrder='đã hoàn thành' ")
    List<Order> listAccomplished();

    @Query(value = "select o from Order o where o.statusOrder='chờ phản hồi' ")
    List<Order> listWait();

    @Query(value = "select o from Order o where o.statusOrder='đã nhận' ")
    List<Order> listReceived();

    List<Order> findAllByProvider (Provider provider);

    List<Order> findAllByUser(User user);
}
