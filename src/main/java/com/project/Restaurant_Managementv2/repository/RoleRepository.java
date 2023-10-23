package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.enums.Roles;
import com.project.Restaurant_Managementv2.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Short> {
Optional<Role> findByName(Roles name);

}
