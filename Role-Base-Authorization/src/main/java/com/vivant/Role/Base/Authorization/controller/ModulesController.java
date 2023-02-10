package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.Modules;
import com.vivant.Role.Base.Authorization.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModulesController
{
    @Autowired
    private ModulesService modulesService;
    @PostMapping("/add")
    public Modules addModules(Modules modules)
    {
        return modulesService.addModule(modules);
    }
    @GetMapping("/list")
    public List<Modules> modulesList()
    {
        return modulesService.getModules();
    }
}
