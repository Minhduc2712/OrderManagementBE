package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.AuthenticationToken;
import com.project.Restaurant_Managementv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Short> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String Token);
}
