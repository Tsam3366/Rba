package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.authentication.AuthenticationRequest;
import com.vivant.Role.Base.Authorization.authentication.AuthenticationResponse;
import com.vivant.Role.Base.Authorization.authentication.AuthenticationService;
import com.vivant.Role.Base.Authorization.dto.RegisterRequest;
import com.vivant.Role.Base.Authorization.dto.UserRolesDto;
import com.vivant.Role.Base.Authorization.dto.Userwithroles;
import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.exceptions.NotFoundException;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import com.vivant.Role.Base.Authorization.repository.UserRepository;
import com.vivant.Role.Base.Authorization.service.RoleService;
import com.vivant.Role.Base.Authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/getall")
    public ResponseEntity<Set<UserRolesDto>> testing() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @PutMapping("/{mail}/{rolename}")
    public ResponseEntity<User> assignRole(@PathVariable String mail, @PathVariable String rolename) {
        User user=userService.findUserByMail(mail);
        Role role=roleService.findByName(rolename);
        user.setUpdated(new Date(System.currentTimeMillis()));
        user.getRoles().add(role);
        return ResponseEntity.ok(userService.addUser(user));
        }

    @GetMapping("/{rolename}")
    public Set<User> getRolesByUser(@PathVariable String rolename)
    {
        Role role=roleService.findByName(rolename);
        if(role==null)
            throw new NotFoundException("Role not found");
        return userService.findUsers(role);
    }
    @GetMapping("getRoles/{mail}")
    public Set<Role> getRoles(@PathVariable String mail)
    {
        User user=userService.findUserByMail(mail);
        return roleService.findRoles(user);
    }
}
