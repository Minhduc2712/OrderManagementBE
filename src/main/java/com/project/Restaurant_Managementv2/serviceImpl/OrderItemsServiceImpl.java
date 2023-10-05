package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.models.OrderItem;
import com.project.Restaurant_Managementv2.repository.OrderItemsRepository;
import com.project.Restaurant_Managementv2.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItem addOrderedProducts(OrderItem orderItem) {
        return orderItemsRepository.save(orderItem);
    }
}
