package com.vivant.Role.Base.Authorization.dto;

import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userwithroles
{
    private User user;
    private List<Role> roles;

    public Userwithroles(Object[] userRolePair) {
        this.user = (User) userRolePair[0];
        this.roles = (List<Role>) userRolePair[1];
    }
}
