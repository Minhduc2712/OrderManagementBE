package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.CheckoutCart;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.models.User;

import java.io.DataOutput;
import java.util.List;

public interface CartService {
        List<Cart> getAggregatedCartByUserId(Short userId);
        List<Cart> addCartByUserIdAndProductId(short productId, Short userId, int qty, double price) throws Exception;
        void updatequantityByCartId(short cartId,int quantity,double price) throws Exception;
        List<Cart> getCartByUserId(short userId);
        List<Cart> removeCartByUserId(short cartId,Short userId);
        List<Cart> removeAllCartByUserId(short userId);
        Boolean checkTotalAmountAgainstCart(double totalAmount,short userId);
        List<CheckoutCart> getAllCheckoutByUserId(short userId);
        List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;

        Double getTotalAmountForUser(short userId);

        Integer getTotalQuantityForUser(short userId);
}