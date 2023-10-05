package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.dto.cart.AddtoCartDto;
import com.project.Restaurant_Managementv2.form.Cart.AddtoCart;
import com.project.Restaurant_Managementv2.form.Cart.CartItem;
import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.repository.CartRepository;
import com.project.Restaurant_Managementv2.repository.OrderRepository;
import com.project.Restaurant_Managementv2.repository.ProductRepository;
import com.project.Restaurant_Managementv2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Cart addtoCart(AddtoCart addtoCart, Product product, User user) {
        Cart cart = new Cart(product, user, addtoCart.getQuantity());
        return cartRepository.save(cart);
    }
    @Override
    public Cart listCartItems(User user){
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItem> cartItems = new ArrayList<>();
        for(Cart cart:cartList){
        CartItem cartItem = getFromCart(cart);
        cartItems.add(cartItem);
        }
        Double totalCost = Double.valueOf(0);
        for(CartItem cartItem: cartItems){
            totalCost += (cartItem.getProduct().getPrice() * cartItem.getQuantity());
        }
        return null;
    }

    public static CartItem getFromCart(Cart cart) {
        return new CartItem(cart);
    }

//    @Override
//    public Cart createNewCart(short ProductId, short CartId, int quantity, CartFormForCreating cartNewForm) {
//        Product product= productRepository.getById(ProductId);
//        Cart cart = cartRepository.getById(CartId);
//        Cart cartNew = cartRepository.save(cart);
//        return cartNew;
//    }
}
