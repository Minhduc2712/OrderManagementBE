package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.dto.checkout.CheckoutItemDto;
import com.project.Restaurant_Managementv2.form.OrderFormForCreating;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.models.Order;
import com.project.Restaurant_Managementv2.repository.UserRepository;
import com.project.Restaurant_Managementv2.repository.OrderRepository;
import com.project.Restaurant_Managementv2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createPricedata(CheckoutItemDto checkoutItem) {
        return null;
    }

    @Override
    public Order createSessionLineItem(CheckoutItemDto checkoutItemDto) {
        return null;
    }


//    @Override
//    public Order createNewOrder(OrderFormForCreating orderNewForm) {
//        Customer customer = customerRepository.getById(orderNewForm.getCustomerId());
//
//
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setStatus(orderNewForm.getStatus());
//        order.setTotal(orderNewForm.getTotal());
//
//        Order orderNew= orderRepository.save(order);
//        return orderNew;
//    }
}
