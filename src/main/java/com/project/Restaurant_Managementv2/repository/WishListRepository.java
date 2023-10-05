package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Short> {
    List<WishList> findAllByUserIdOrderByCreatedDateDesc(Short userId);
}
