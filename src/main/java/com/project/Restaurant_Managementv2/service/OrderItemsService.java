package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.models.Order;
import com.project.Restaurant_Managementv2.models.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderItemsService {
    public OrderItem addOrderedProducts(OrderItem orderItem);
}
