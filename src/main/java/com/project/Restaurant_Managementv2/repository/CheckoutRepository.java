package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.CheckoutCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutCart, Short> {
    @Query("SELECT checkCart FROM CheckoutCart checkCart WHERE checkCart.user.id = :user_id")
    List<CheckoutCart> getByUser(@Param("user_id") short user_id);
}
