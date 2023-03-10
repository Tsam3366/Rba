package com.vivant.Role.Base.Authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest
{
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private String status;
    private String password;
}
