package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.form.OrderFormForCreating;
import com.project.Restaurant_Managementv2.models.Order;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    @PostMapping()
//    public ResponseEntity<ResponseObject> createNewOrder(@RequestBody OrderFormForCreating orderNewForm){
//        Order orderNew = orderService.createNewOrder(orderNewForm);

//        OrderDto  orderNewDto = new OrderDto();
//        orderNewDto.setId(orderNew.getId());
//        orderNewDto.setCustomerName(orderNew.getCustomer().getUsername());
//        orderNewDto.setStatus(orderNew.getStatus());
//        orderNewDto.setTotal(orderNew.getTotal());
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok","Created order successfully",orderNewDto));
//
//    }
}


