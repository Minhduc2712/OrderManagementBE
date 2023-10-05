package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Short> {
}
