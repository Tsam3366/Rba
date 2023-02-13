package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService
{
    @Autowired
    private RoleRepository roleRepository;
    public Role addRole(Role role)
    {
        return roleRepository.save(role);
    }
    public List<Role> getRoles()
    {
        return roleRepository.findAll();
    }
    public List<String> rolesName()
    {
        List<Role> roles=roleRepository.findAll();
        List<String> roleNames=new ArrayList<>();
        for(Role r:roles)
        {
            roleNames.add(r.getName());
        }
        return roleNames;
    }
    public Role findByName(String name)
    {return roleRepository.findByName(name);}
    public List<Role> findRoles(User user)
    {
        return roleRepository.findByUsers(user);
    }
}
