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
    @Column(unique = true)
    private String name;
    private boolean status;
    private Date created;
    private Date updated;
    @OneToMany(mappedBy = "modules", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ModuleActions> modules = new HashSet<>();
}
