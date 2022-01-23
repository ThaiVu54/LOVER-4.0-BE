package com.example.lover.service.provider;

import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import com.example.lover.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    IProviderRepository providerRepository;

    @Override
    public Page<Provider> pageFindAll(Pageable pageable) {
        return providerRepository.findAll(pageable);
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id);
    }

    @Override
    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public void remove(Long id) {
        providerRepository.deleteById(id);
    }

    public void delete(Provider provider) {
        providerRepository.delete(provider);
    }

    @Override
    public List<Provider> top6Provider() {
        return providerRepository.top6Provider();
    }

    @Override
    public Page<Provider> findAllByNameContaining(String name, Pageable pageable) {
        return providerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Optional<Provider> findByUser(User user) {
        return providerRepository.findByUser(user);
    }

    @Override
    public Page<Provider> findAllByConfirmAndActive(Boolean isConfirm, Boolean IsActive, Pageable pageable) {
        return providerRepository.findAllByConfirmAndActive(isConfirm, IsActive, pageable);
    }

    @Override
    public Page<Provider> search(String name, int minYear, int maxYear, String gender, String city, Pageable pageable) {
        return providerRepository.search("%"+name+"%", minYear, maxYear, gender, city, pageable);
    }

    @Override
    public List<Provider> find12ProviderFemale() {
        return providerRepository.find12ProviderFemale();
    }

    @Override
    public List<Provider> find12ProviderMale() {
        return providerRepository.find12ProviderMale();
    }

    @Override
    public List<Provider> findTop8Female() {
        return providerRepository.findTop8Famale();
    }

    @Override
    public List<Provider> findTop4Male() {
        return providerRepository.findTop4Male();
    }

    @Override
    public Page<Provider> findProviderByGenderMale(String gender, Pageable pageable) {
        return providerRepository.findProviderByGenderMale(gender, pageable);
    }

    @Override
    public Page<Provider> findProviderByGenderFemale(String gender, Pageable pageable) {
        return providerRepository.findProviderByGenderFemale(gender, pageable);
    }

    @Override
    public Page<Provider> findAllByConfirm(Boolean isConfirm, Pageable pageable) {
        return providerRepository.findAllByConfirm(isConfirm, pageable);
    }

    public Provider findByUserId(Long id) {
        List<Provider> providers = findAll();
        Provider provider1 = null;
        for (Provider provider : providers
        ) {
            if (provider.getUser().getId() == id) {
                provider1 = provider;
            }
        }
        return provider1;
    }
}
