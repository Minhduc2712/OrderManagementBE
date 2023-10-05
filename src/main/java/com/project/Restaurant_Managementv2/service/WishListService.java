package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.models.WishList;

import java.util.List;

public interface WishListService {
    public WishList createWishlist(WishList wishList);

    public List<WishList> readWishList(Short customerId);

}
