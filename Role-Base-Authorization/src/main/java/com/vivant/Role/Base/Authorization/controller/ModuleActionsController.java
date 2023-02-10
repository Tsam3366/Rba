package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import com.vivant.Role.Base.Authorization.service.ModuleActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moduleactions")
public class ModuleActionsController
{
    @Autowired
    private ModuleActionsService moduleActionsService;
    @PostMapping("/assignmodule/{module}/{action}")
    public ResponseEntity<ModuleActions> assignmodule(@PathVariable String module,@PathVariable String action)
    {
        ModuleActions moduleActions=new ModuleActions();
        return ResponseEntity.ok(moduleActionsService.save(moduleActions));
    }
}
