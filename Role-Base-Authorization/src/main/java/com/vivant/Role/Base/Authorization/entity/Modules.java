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
@Table(name="modules")
public class Modules
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String modulename;
    private boolean status=true;
    private Date created=new Date(System.currentTimeMillis());
    private Date updated=null;
    @OneToMany(mappedBy = "modules", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ModuleActions> modulesActions = new HashSet<>();
}
