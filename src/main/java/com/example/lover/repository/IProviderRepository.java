package com.example.lover.repository;

import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Long> {
    //top 6 xem nhieu nhat
    @Query(value = "select p from Provider p order by p.view Desc", nativeQuery = false)
    List<Provider> top6Provider();

    //tim kiem theo ten
    Page<Provider> findAllByNameContaining(String name, Pageable pageable);

    //tim theo user
    Optional<Provider> findByUser(User user);

    //tim theo trang thai hoat dong
    @Query(value = "select c from Provider c where c.isConfirm=?1 and c.isActive=?2")
    Page<Provider> findAllByConfirmAndActive(Boolean isConfirm, Boolean IsActive, Pageable pageable);

    //tim kiem chi tiet provider
    @Query(value = "select s from Provider s where s.name like ?1 and (s.yearOfBirth between ?2 and ?3) and s.gender=?4 and s.city=?5 and s.isConfirm=true and s.isActive=true")
    Page<Provider> search(String name, int minYear, int maxYear, String gender, String city, Pageable pageable);

    //hien thi 12 cung cap dich vu nu
    @Query(value = "select s from Provider s where s.gender = 'nữ' and s.isConfirm=true and s.isConfirm=true")
    List<Provider> find12ProviderFemale();

    //hien thi 12 cung cap dich vu nam
    @Query(value = "select s from Provider s where s.gender = 'nam' and s.isConfirm=true and s.isConfirm=true")
    List<Provider> find12ProviderMale();

    //hien thi top 8 nu hot nhat
    @Query(value = "select f from Provider f where f.gender = 'nữ' and f.isConfirm=true and f.isActive=true order by f.count desc")
    List<Provider> findTop8Famale();
//    hien thi top 4 nam hot nhat
    @Query(value ="select f from Provider f where f.gender = 'nam' and f.isConfirm=true and f.isActive=true order by f.count desc")
    List<Provider> findTop4Male();

    @Query(value = "SELECT s FROM Provider s  WHERE s.gender='nam' ")
    Page<Provider> findProviderByGenderMale (String gender,Pageable pageable);

    @Query(value = "SELECT s FROM Provider s  WHERE s.gender='nữ'  ")
    Page<Provider> findProviderByGenderFemale (String gender,Pageable pageable);

    @Query(value = "SELECT s FROM Provider s WHERE s.isConfirm=?1")
    Page<Provider> findAllByConfirm(Boolean isConfirm,Pageable pageable);
}
