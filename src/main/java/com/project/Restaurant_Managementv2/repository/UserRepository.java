package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Short> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Short id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findByEmailOrUsername(String email, String username);

    User findCustomerByEmail(String email);



}
