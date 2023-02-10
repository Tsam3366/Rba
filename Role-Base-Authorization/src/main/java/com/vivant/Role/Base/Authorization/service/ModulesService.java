package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Modules;
import com.vivant.Role.Base.Authorization.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService
{
    @Autowired
    private ModulesRepository modulesRepository;
    public Modules addModule(Modules modules)
    {
        return modulesRepository.save(modules);
    }
    public List<Modules> getModules()
    {
        return modulesRepository.findAll();
    }
}
