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

        return userRepository.save(user);
    }

    public User findUserByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public List<Role> listRoles(String mail) {
        return userRepository.findByEmail(mail).getRoles();
    }

    public List<User> findUsers(Role role) {
        return userRepository.findByRoles(role);
    }
    public List<UserRolesDto> getUsers()
    {
        List<User> user=userRepository.findAll();
        List<UserRolesDto> userRolesDtos=new ArrayList<>();
        for(User u:user){
            Set<String> roleNames=new HashSet<>();
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
