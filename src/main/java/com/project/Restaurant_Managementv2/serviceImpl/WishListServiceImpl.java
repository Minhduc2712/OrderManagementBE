package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.models.WishList;
import com.project.Restaurant_Managementv2.repository.WishListRepository;
import com.project.Restaurant_Managementv2.service.WishListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {
    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public WishList createWishlist(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public List<WishList> readWishList(Short customerId) {
        return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(customerId);
    }
}
