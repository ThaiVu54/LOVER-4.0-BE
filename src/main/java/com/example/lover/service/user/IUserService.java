package com.example.lover.service.user;

import com.example.lover.model.account.User;
import com.example.lover.service.IServiceGeneral;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface IUserService extends IServiceGeneral<User> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
