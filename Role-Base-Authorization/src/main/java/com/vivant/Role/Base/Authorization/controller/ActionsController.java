package com.vivant.Role.Base.Authorization.controller;

import com.vivant.Role.Base.Authorization.entity.Actions;
import com.vivant.Role.Base.Authorization.repository.ActionsRepository;
import com.vivant.Role.Base.Authorization.service.ActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionsController
{
    @Autowired
    private ActionsService actionsService;
    @PostMapping("/add")
    public Actions addActions(Actions actions)
    {
        return actionsService.addActions(actions);
    }
    @GetMapping
    public String hi()
    {
        return "helo";
    }
    @GetMapping("/list")
    public List<Actions> getActions()
    {
        return  actionsService.getActions();
    }

}
