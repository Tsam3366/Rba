package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.dto.RoleDto;
import com.vivant.Role.Base.Authorization.dto.UserRolesDto;
import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.exceptions.NotFoundException;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import com.vivant.Role.Base.Authorization.service.RoleService;
import com.vivant.Role.Base.Authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }
    @PostMapping("/addrole")
    public Role addRole(@RequestBody RoleDto roledto)
    {
        var role=Role.builder()
                .name(roledto.getName())
                .status(true)
                .created(new Date(System.currentTimeMillis()))
                .updated(null).build();
        return roleService.addRole(role);
    }
    @GetMapping("{username}")
    public List<Role> getUsers(@PathVariable String username)
    {
        User user=userService.findUserByMail(username);
        if(user==null)
            throw new NotFoundException("User Not Found");

        return roleService.findRoles(user);
    }

}
