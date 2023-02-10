package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permissions,Integer>
{
}
