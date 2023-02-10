package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleActionsRepo extends JpaRepository<ModuleActions,Integer>
{
    List<Integer> ids;
}
