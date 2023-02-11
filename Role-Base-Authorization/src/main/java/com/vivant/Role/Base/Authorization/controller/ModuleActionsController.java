package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import com.vivant.Role.Base.Authorization.entity.Modules;
import com.vivant.Role.Base.Authorization.service.ActionsService;
import com.vivant.Role.Base.Authorization.service.ModuleActionsService;
import com.vivant.Role.Base.Authorization.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moduleactions")
public class ModuleActionsController
{
    @Autowired
    private ModuleActionsService moduleActionsService;
    @Autowired
    private ModulesService modulesService;
    @Autowired
    private ActionsService actionsService;

    @PostMapping("/assignmodule/{module}/{action}")
    public ResponseEntity<ModuleActions> assignmodule(@PathVariable String module, @PathVariable String action)
    {
        ModuleActions moduleActions=new ModuleActions();
        Modules m=modulesService.getModule(module);
        Actions a=actionsService.getAction(action);
        moduleActions.setActions(a);
        moduleActions.setModules(m);
        return ResponseEntity.ok(moduleActionsService.save(moduleActions));
    }
    @GetMapping("/{mname}")
    public List<String> getActions(@PathVariable String mname)
    {
        int mid=modulesService.getModule(mname).getId();
        return moduleActionsService.getActionIdList(mid);
    }
}
