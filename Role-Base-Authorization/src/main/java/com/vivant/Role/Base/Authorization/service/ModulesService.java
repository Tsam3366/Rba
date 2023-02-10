package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Modules;
import com.vivant.Role.Base.Authorization.repository.ModulesRepository;
import com.vivant.Role.Base.Authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService
{
    @Autowired
    private ModulesRepository modulesRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Modules addModule(Modules modules)
    {
        return modulesRepository.save(modules);
    }
    public Modules getModule(String name)
    {
        return modulesRepository.findByModulename(name);
    }
    public List<Modules> getModules()
    {
        return modulesRepository.findAll();
    }
}
