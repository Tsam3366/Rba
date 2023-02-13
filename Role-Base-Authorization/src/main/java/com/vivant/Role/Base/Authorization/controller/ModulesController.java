package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.Modules;
import com.vivant.Role.Base.Authorization.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
@CrossOrigin("http://localhost:3000/")
public class ModulesController
{
    @Autowired
    private ModulesService modulesService;
    @PostMapping("/add")
    public Modules addModules(@RequestBody Modules modules)
    {
        return modulesService.addModule(modules);
    }
    @GetMapping("/list")
    public List<Modules> modulesList()
    {
        return modulesService.getModules();
    }
}
