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
@Table(name="moduleactions")
public class ModuleActions
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean status;
    private Date created;
    private Date updated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
    private Actions actions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id")
    private Modules modules;
    @OneToMany(mappedBy = "moduleActions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Permissions> permissions = new HashSet<>();
}
