package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulesRepository extends JpaRepository<Modules,Integer>
{

    Modules findByModulename(String name);

}
