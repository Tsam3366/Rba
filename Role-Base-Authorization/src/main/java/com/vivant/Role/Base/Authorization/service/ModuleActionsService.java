package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import com.vivant.Role.Base.Authorization.repository.ModuleActionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleActionsService
{
    @Autowired
    private ModuleActionsRepo moduleActionsRepo;
    public ModuleActions save(ModuleActions moduleActions)
    {
        return moduleActionsRepo.save(moduleActions);
    }
}
