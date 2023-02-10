package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService
{
    @Autowired
    private RoleRepository roleRepository;
    public Role addRole(Role role)
    {
        return roleRepository.save(role);
    }
    public Role findByName(String name)
    {return roleRepository.findByName(name);}
    public Set<Role> findRoles(User user)
    {
        return roleRepository.findByUsers(user);
    }
}
