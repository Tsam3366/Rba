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
@Table(name="actions")
public class Actions
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String name;
    private String description;
    private Date created=new Date(System.currentTimeMillis());
    private Date updated=null;
    @OneToMany(mappedBy = "actions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ModuleActions> actions = new HashSet<>();
}
