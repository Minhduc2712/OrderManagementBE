package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.dto.checkout.CheckoutItemDto;
import com.project.Restaurant_Managementv2.form.OrderFormForCreating;
import com.project.Restaurant_Managementv2.models.Order;

public interface OrderService {
//    public Order createNewOrder(OrderFormForCreating orderNewForm);

    public Order createPricedata(CheckoutItemDto checkoutItem);

    public Order createSessionLineItem(CheckoutItemDto checkoutItemDto);
}
