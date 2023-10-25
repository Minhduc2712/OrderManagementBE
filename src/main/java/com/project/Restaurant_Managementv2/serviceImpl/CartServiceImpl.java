package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.CheckoutCart;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.repository.*;
import com.project.Restaurant_Managementv2.service.CartService;
import com.project.Restaurant_Managementv2.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.slf4j.Logger;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    CheckoutRepository checkoutRepository;
    @Autowired
    ProductService productServices;

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    public List<Cart> getAggregatedCartByUserId(Short userId) {
        List<Cart> cartItems = cartRepository.getCartByUserId(userId);

        Map<Short, Cart> aggregatedMap = new HashMap<>();

        for (Cart cartItem : cartItems) {
            Short productId = cartItem.getProduct().getId();
            Cart existingItem = aggregatedMap.get(productId);

            if (existingItem == null) {
                aggregatedMap.put(productId, cartItem);
            } else {
                existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity());
                existingItem.setPrice(existingItem.getPrice() + cartItem.getPrice());
            }
        }

        return new ArrayList<>(aggregatedMap.values());
    }

    @Override
    public List<Cart> addCartByUserIdAndProductId(short productId, Short userId, int qty, double price) throws Exception {
        List<Cart> userCarts = cartRepository.getCartByUserId(userId);

        Optional<Cart> existingCartItem = userCarts.stream()
                .filter(cart -> cart.getProduct().getId() == productId)
                .findFirst();

        if (existingCartItem.isPresent()) {
            Cart cart = existingCartItem.get();
            int newQty = cart.getQuantity() + qty;
            double newPrice = calculateNewPrice(price, newQty, cart.getProduct().getPrice());
            cart.setQuantity(newQty);
            cart.setPrice(newPrice);
            cartRepository.save(cart);
        } else {
            Cart newCart = new Cart();
            newCart.setQuantity(qty);
            newCart.setUser(userId);
            Product product = productServices.getProductById(productId);
            newCart.setId(productId);
            newCart.setProduct(product);
            newCart.setPrice(price);
            cartRepository.save(newCart);
        }

        return this.getAggregatedCartByUserId(userId);
    }
    private double calculateNewPrice(double newPrice, int newQty, double productPrice) {
        return newPrice * newQty;
    }


    @Override
    public void updatequantityByCartId(short cartId, int quantity, double price) throws Exception {
        cartRepository.updateQtyByCartId(cartId,price,quantity);
    }

    @Override
    public List<Cart> getCartByUserId(short userId) {
        return cartRepository.getCartByUserId(userId);
    }

    @Override
    public List<Cart> removeCartByUserId(short cartId, Short userId) {
        cartRepository.deleteCartByIdAndUserId(userId,cartId);
        return this.getCartByUserId(userId);
    }

    @Override
    public List<Cart> removeAllCartByUserId(short userId) {
        cartRepository.deleteAllCartByUserId(userId);
        return null;
    }

    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, short userId) {
        double total_amount =cartRepository.getTotalAmountForUser(userId);
        if(total_amount == totalAmount) {
            return true;
        }
        System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
        return false;
    }

    @Override
    public List<CheckoutCart> getAllCheckoutByUserId(short userId) {
        return checkoutRepository.getByUser(userId);
    }

    @Override
    public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
        try {
            short user_id = tmp.get(0).getUser().getId();
            if(tmp.size() >0) {
                checkoutRepository.saveAll(tmp);
                this.removeAllCartByUserId(user_id);
                return this.getAllCheckoutByUserId(user_id);
            }
            else {
                throw  new Exception("Should not be empty");
            }
        }catch(Exception e) {
            throw new Exception("Error while checkout "+e.getMessage());
        }

    }

    @Override
    public Double getTotalAmountForUser(short userId) {
        return cartRepository.getTotalAmountForUser(userId);
    }

    @Override
    public Integer getTotalQuantityForUser(short userId) {
        return cartRepository.getTotalQuantityForUser(userId);
    }

}