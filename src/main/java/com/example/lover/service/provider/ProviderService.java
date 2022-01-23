package com.example.lover.service.provider;

import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService implements IProviderService{
    @Autowired IProviderService providerService;
    @Override
    public Page<Provider> pageFindAll(Pageable pageable) {
        return providerService.pageFindAll(pageable);
    }

    @Override
    public List<Provider> findAll() {
        return providerService.findAll();
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return providerService.findById(id);
    }

    @Override
    public Provider save(Provider provider) {
        return providerService.save(provider);
    }

    @Override
    public void remove(Long id) {
    providerService.remove(id);
    }

    @Override
    public List<Provider> top6Provider() {
        return providerService.top6Provider();
    }

    @Override
    public Provider findByUserId(Long id) {
        List<Provider> providers = findAll();
        Provider providers1 = null;
        for (Provider provider: providers
             ) {
            if (provider.getId() == id){
                providers1 = provider;
            }
        }
        return providers1;
    }

    @Override
    public Page<Provider> findAllByNameContaining(String name, Pageable pageable) {
        return providerService.findAllByNameContaining(name, pageable);
    }

//    @Override
//    public Optional<Provider> findAllByUser(User user) {
//        return Optional.empty();
//    }

    @Override
    public Page<Provider> findAllByConfirmAndActive(Boolean isConfirm, Boolean IsActive, Pageable pageable) {
        return providerService.findAllByConfirmAndActive(isConfirm, IsActive, pageable);
    }

    @Override
    public Page<Provider> search(String name, int minYear, int maxYear, String gender, String city, Pageable pageable) {
        return providerService.search("%"+name+"%", minYear, maxYear, gender ,city, pageable);
    }

    @Override
    public List<Provider> find12ProviderFemale() {
        return providerService.find12ProviderFemale();
    }

    @Override
    public List<Provider> find12ProviderMale() {
        return providerService.find12ProviderMale();
    }

    @Override
    public List<Provider> findTop8Female() {
        return providerService.findTop8Female();
    }

    @Override
    public List<Provider> findTop4Male() {
        return providerService.findTop4Male();
    }

    @Override
    public Page<Provider> findProviderByGenderMale(String gender, Pageable pageable) {
        return providerService.findProviderByGenderMale(gender, pageable);
    }

    @Override
    public Page<Provider> findProviderByGenderFemale(String gender, Pageable pageable) {
        return providerService.findProviderByGenderFemale(gender, pageable);
    }

    @Override
    public Page<Provider> findAllByConfirm(Boolean isConfirm, Pageable pageable) {
        return providerService.findAllByConfirm(isConfirm,pageable);
    }
}
