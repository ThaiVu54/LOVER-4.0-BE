package com.example.lover.service.role;

import com.example.lover.model.account.Role;
import com.example.lover.model.account.RoleName;
import com.example.lover.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleService implements IRoleService{
    @Autowired private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
