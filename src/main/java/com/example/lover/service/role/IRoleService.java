package com.example.lover.service.role;

import com.example.lover.model.account.Role;
import com.example.lover.model.account.RoleName;
import com.example.lover.service.IServiceGeneral;

import java.util.Optional;


public interface IRoleService extends IServiceGeneral<Role> {
    Optional<Role> findByName(RoleName name);


}
