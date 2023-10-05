package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Short> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);
}
