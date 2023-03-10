package com.vivant.Role.Base.Authorization.service;


import com.vivant.Role.Base.Authorization.dto.UserRolesDto;
import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import com.vivant.Role.Base.Authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User findUserByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public Set<Role> listRoles(String mail) {
        return userRepository.findByEmail(mail).getRoles();
    }

    public Set<User> findUsers(Role role) {
        return userRepository.findByRoles(role);
    }
    public Set<UserRolesDto> getUsers()
    {
        List<User> user=userRepository.findAll();
        Set<UserRolesDto> userRolesDtos=new HashSet<>();
        for(User u:user){
            List<String> roleNames=new ArrayList<>();
            for(Role role:roleRepository.findByUsers(u))
            {
                roleNames.add(role.getName());
            }
            var temp=UserRolesDto.builder()
                    .firstname(u.getFirstname())
                    .lastname(u.getLastname())
                    .email(u.getEmail())
                    .mobile(u.getMobile())
                    .status(u.isStatus())
                    .userCreated(u.getCreated())
                    .userUpdated(u.getUpdated())
                    .roles(roleNames).build();
            userRolesDtos.add(temp);
        }
        return userRolesDtos;
    }


}
