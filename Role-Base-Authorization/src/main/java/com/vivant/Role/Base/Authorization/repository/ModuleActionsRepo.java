package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.ModuleActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ModuleActionsRepo extends JpaRepository<ModuleActions,Integer>
{
    @Query(value = "select * from moduleactions where module_id=:id",nativeQuery = true)
    Set<ModuleActions> ids(int id);
    ModuleActions findById(int id);
}
