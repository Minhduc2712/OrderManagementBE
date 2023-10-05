package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.dto.cart.AddtoCartDto;
import com.project.Restaurant_Managementv2.form.Cart.AddtoCart;
import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.models.User;

public interface CartService {
//    public Cart createNewCart(short CartId, short ProductId, int quantity, CartFormForCreating cartNewForm);
        public Cart addtoCart(AddtoCart addtoCart, Product product, User user);

        public Cart listCartItems(User user);

}
