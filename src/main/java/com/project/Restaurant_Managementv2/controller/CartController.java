package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;

//    @PostMapping("/users/{idUser}/carts/{idCart}")
//    public Cart createNewCart(@PathVariable("idCart") short idCart, @RequestParam("idProduct") short idProduct, @RequestParam("quantity") Integer quantity, CartFormForCreating cartNewForm){
//        return cartService.createNewCart(idCart,idProduct,quantity,cartNewForm);
//    }
}
