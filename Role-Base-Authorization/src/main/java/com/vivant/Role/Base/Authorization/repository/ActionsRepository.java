package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionsRepository extends JpaRepository<Actions,Integer> {
    Actions findByName(String name);
}
