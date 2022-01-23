package com.example.lover.service.service;


import com.example.lover.model.account.Services;
import com.example.lover.model.account.User;
import com.example.lover.service.IServiceGeneral;
import org.springframework.stereotype.Service;

@Service
public interface IServiceService extends IServiceGeneral<Services> {
    Iterable<Services>findAllByUser(User user);

}
