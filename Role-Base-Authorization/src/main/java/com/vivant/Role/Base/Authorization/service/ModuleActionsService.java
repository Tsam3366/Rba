package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import com.vivant.Role.Base.Authorization.repository.ActionsRepository;
import com.vivant.Role.Base.Authorization.repository.ModuleActionsRepo;
import com.vivant.Role.Base.Authorization.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModuleActionsService
{
    @Autowired
    private ModuleActionsRepo moduleActionsRepo;
    @Autowired
    private ModulesRepository modulesRepository;
    @Autowired
    private ActionsRepository actionsRepository;

    public ModuleActions save(ModuleActions moduleActions)
    {
        return moduleActionsRepo.save(moduleActions);
    }
    public Set<Actions> getActionIdList(int moduleId){
        Set<ModuleActions> moduleActions= moduleActionsRepo.ids(moduleId);
        Set<Integer> actionIds=new HashSet<>();
        for(ModuleActions ma:moduleActions)
        {
            actionIds.add(ma.getActions().getId());
        }
        Set<Actions> actionNames=new HashSet<>();
        for(int a:actionIds)
        {
            Actions act=actionsRepository.findById(a);
            actionNames.add(act);
        }
        System.out.println(actionNames.toString());
        return actionNames;
    }
}
