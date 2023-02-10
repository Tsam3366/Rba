package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.repository.ActionsRepository;
import com.vivant.Role.Base.Authorization.service.ActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionsController
{
    @Autowired
    private ActionsService actionsService;

    @PostMapping("/add")
    public Actions addActions(@RequestBody Actions actions)
    {
        return actionsService.addActions(actions);
    }
    @GetMapping("/list")
    public List<Actions> getActions()
    {
        return  actionsService.getActions();
    }

}
