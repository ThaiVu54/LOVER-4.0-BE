package com.example.lover.service.service;

import com.example.lover.model.account.Services;
import com.example.lover.model.account.User;
import com.example.lover.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Iterable<Services> findAllByUser(User user) {
        return serviceRepository.findAllByUser(user);
    }

    @Override
    public Page<Services> pageFindAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Services> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Services save(Services services) {
        return serviceRepository.save(services);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
