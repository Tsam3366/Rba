package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import com.vivant.Role.Base.Authorization.repository.ActionsRepository;
import com.vivant.Role.Base.Authorization.repository.ModuleActionsRepo;
import com.vivant.Role.Base.Authorization.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> getActionIdList(int moduleId){
        List<Integer> actiondIds= moduleActionsRepo.ids(moduleId);
        System.out.println(actiondIds.toString());
        List<String> actionNames=new ArrayList<>();
        for(int a:actiondIds)
        {
            Actions act=actionsRepository.findById(a);
            actionNames.add(act.getName());
        }
        return actionNames;
    }
}
