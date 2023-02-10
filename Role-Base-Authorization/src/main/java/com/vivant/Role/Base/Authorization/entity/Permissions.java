package com.vivant.Role.Base.Authorization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="permissions")
public class Permissions
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean status;
    private Date created;
    private Date updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_action_id")
    private ModuleActions moduleActions;
}
