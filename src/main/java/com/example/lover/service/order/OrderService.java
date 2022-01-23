package com.example.lover.service.order;

import com.example.lover.model.account.Order;
import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import com.example.lover.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class OrderService implements IOrderService{
    @Autowired private IOrderRepository orderRepository;
    @Override
    public Page<Order> pageFindAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
orderRepository.deleteById(id);
    }

    @Override
    public List<Order> listAccomplished() {
        return orderRepository.listAccomplished();
    }

    @Override
    public List<Order> listWait() {
        return orderRepository.listWait();
    }

    @Override
    public List<Order> listReceived() {
        return orderRepository.listReceived();
    }

    @Override
    public List<Order> findAllByProvider(Provider provider) {
        return orderRepository.findAllByProvider(provider);
    }

    @Override
    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }
}
