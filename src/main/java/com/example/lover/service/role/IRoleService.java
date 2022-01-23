package com.example.lover.service.role;

import com.example.lover.model.account.Role;
import com.example.lover.model.account.RoleName;

import java.util.Optional;


public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
