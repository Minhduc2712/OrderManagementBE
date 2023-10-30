package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Short> {
    List<Cart> getCartByUserId(@Param("user_id") Short user_id);

    @Query("Select cart FROM Cart cart WHERE cart.product.id= :product_id and cart.userId= :user_id")
    Optional<Cart> getCartByProductIdAndUserId(@Param("user_id") Short user_id, @Param("product_id") Short product_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cart cart WHERE cart.id = :cart_id AND cart.userId = :user_id")
    void deleteCartByIdAndUserId(@Param("user_id") short user_id, @Param("cart_id") Short cart_id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart cart WHERE cart.userId = :user_id")
    void deleteAllCartByUserId(@Param("user_id") short user_id);

    @Modifying
    @Transactional
    @Query("UPDATE Cart cart SET cart.quantity = :qty, cart.price = :price WHERE cart.id = :cart_id")
    void updateQtyByCartId(@Param("cart_id") Short cart_id, @Param("price") double price, @Param("qty") Integer qty);

    @Query("SELECT COALESCE(SUM(c.price), 0) FROM Cart c WHERE c.userId = :user_id")
    Double getTotalAmountForUser(@Param("user_id") short user_id);

    @Query("SELECT COALESCE(SUM(c.quantity), 0) FROM Cart c WHERE c.userId = :user_id")
    Integer getTotalQuantityForUser(@Param("user_id") short user_id);

    @Query("SELECT cart FROM Cart cart WHERE cart.product = :product")
    List<Cart> findByProduct(Product product);
}
