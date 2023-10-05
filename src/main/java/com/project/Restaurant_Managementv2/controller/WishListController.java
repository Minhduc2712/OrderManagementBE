package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.dto.product.ProductDto;
import com.project.Restaurant_Managementv2.form.ProductFormForCreating;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.models.WishList;
import com.project.Restaurant_Managementv2.service.AuthenticationService;
import com.project.Restaurant_Managementv2.service.ProductService;
import com.project.Restaurant_Managementv2.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {
    @Autowired
    private WishListService wishListService;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ProductService productService;

    @GetMapping("/{token}")
    public ResponseEntity<ResponseObject> getWishList(@PathVariable("token") String token){
        int customerId = authenticationService.getUser(token).getId();
        List<WishList> body= wishListService.readWishList((short) customerId);
        ProductDto productNewDto = new ProductDto();
        for(WishList wishList:body){
           productNewDto.setId(wishList.getProduct().getId());
           productNewDto.setName(wishList.getProduct().getName());
           productNewDto.setCountry(wishList.getProduct().getCountry());
           productNewDto.setImg(wishList.getProduct().getImg());
           productNewDto.setPrice(wishList.getProduct().getPrice());
           productNewDto.setRate(wishList.getProduct().getRate());
           productNewDto.setCategoryName(wishList.getProduct().getCategory().getName());

       }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok","Created product successfully",productNewDto));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> createWishList(@RequestBody Product product, @RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        WishList wishList= new WishList(user,product);
        wishListService.createWishlist(wishList);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok","Created product successfully",wishList));
    }
}
