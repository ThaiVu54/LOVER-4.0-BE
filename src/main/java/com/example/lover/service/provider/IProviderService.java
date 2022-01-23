package com.example.lover.service.provider;

import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import com.example.lover.service.IServiceGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProviderService extends IServiceGeneral<Provider> {
    List<Provider> top6Provider();
    Provider findByUserId(Long id);
    Page<Provider> findAllByNameContaining(String name, Pageable pageable);
//    Optional<Provider> findAllByUser(User user);
    Page<Provider> findAllByConfirmAndActive(Boolean isConfirm, Boolean IsActive, Pageable pageable);
    Page<Provider> search(String name, int minYear, int maxYear, String gender, String city, Pageable pageable);
    List<Provider> find12ProviderFemale();
    List<Provider> find12ProviderMale();
    List<Provider> findTop8Female();
    List<Provider> findTop4Male();
    Page<Provider> findProviderByGenderMale (String gender,Pageable pageable);
    Page<Provider> findProviderByGenderFemale (String gender,Pageable pageable);
    Page<Provider> findAllByConfirm(Boolean isConfirm,Pageable pageable);

}
