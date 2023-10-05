package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Short > {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);
}
