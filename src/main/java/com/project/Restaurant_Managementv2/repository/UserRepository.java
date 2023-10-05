package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Short> {

    User findByUsername(String username);

    User findByEmailOrUsername(String email, String username);

    User findCustomerByEmail(String email);



}
