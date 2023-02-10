package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActionsRepository extends JpaRepository<Actions,Integer> {
    Actions findByName(String name);
    Actions findById(int id);
}
