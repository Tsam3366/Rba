package com.vivant.Role.Base.Authorization.repository;

import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String mail);

    List<User> findByRoles(Role role);
}
