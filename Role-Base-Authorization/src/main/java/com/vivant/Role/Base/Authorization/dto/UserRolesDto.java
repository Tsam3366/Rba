package com.vivant.Role.Base.Authorization.dto;

import com.vivant.Role.Base.Authorization.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRolesDto
{
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private boolean status;
    private Date userCreated;
    private Date userUpdated;
    private Set<String> roles;
}
