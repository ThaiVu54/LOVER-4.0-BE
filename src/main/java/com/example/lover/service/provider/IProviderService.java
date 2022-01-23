package com.example.lover.service.provider;

import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import com.example.lover.service.IServiceGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProviderService extends IServiceGeneral<Provider> {
    List<Provider> top6Provider();

    //tim kiem theo ten
    Page<Provider> findAllByNameContaining(String name, Pageable pageable);

    //tim theo user
    Optional<Provider> findByUser(User user);

    //tim theo trang thai hoat dong
    Page<Provider> findAllByConfirmAndActive(Boolean isConfirm, Boolean IsActive, Pageable pageable);

    //tim kiem chi tiet provider
    Page<Provider> search(String name, int minYear, int maxYear, String gender, String city, Pageable pageable);

    //hien thi 12 cung cap dich vu nu
    List<Provider> find12ProviderFemale();

    //hien thi 12 cung cap dich vu nam
    List<Provider> find12ProviderMale();

    //hien thi top 8 nu hot nhat
    List<Provider> findTop8Female();
    //    hien thi top 4 nam hot nhat
    List<Provider> findTop4Male();

    Page<Provider> findProviderByGenderMale (String gender,Pageable pageable);

    Page<Provider> findProviderByGenderFemale (String gender,Pageable pageable);

    Page<Provider> findAllByConfirm(Boolean isConfirm,Pageable pageable);
}
