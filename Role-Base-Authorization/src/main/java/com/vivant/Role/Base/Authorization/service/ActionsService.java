package com.vivant.Role.Base.Authorization.service;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.repository.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionsService
{
    @Autowired
    private ActionsRepository actionsRepository;
    public Actions addActions(Actions actions)
    {
        return actionsRepository.save(actions);
    }
    public List<Actions> getActions()
    {
        return actionsRepository.findAll();
    }
}
