package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.security.jwt.ShoppingConfiguration;
import com.project.Restaurant_Managementv2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CartController {

    @Autowired
    CartService cartService;
    @PostMapping("cart/addProduct")
    public ResponseEntity<ResponseObject> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
        try {
            String keys[] = {"productId","userId","qty","price"};
            if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            short productId = Short.parseShort(addCartRequest.get("productId"));
            short userId =  Short.parseShort(addCartRequest.get("userId"));
            int qty =  Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            List<Cart> obj = cartService.addCartByUserIdAndProductId((short) productId, (short) userId,qty,price);
            Double totalAmount = cartService.getTotalAmountForUser(userId);
            Integer totalQuantity = cartService.getTotalQuantityForUser(userId);
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String formattedTotalAmount = decimalFormat.format(totalAmount);
            Map<String, Object> response = new HashMap<>();
            response.put("cart", obj);
            response.put("totalAmount", totalAmount);
            response.put("totalQuantity", totalQuantity);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok", "add ok", response));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseObject("failed", "add failed",""));
        }
    }

    @PostMapping("cart/updateQtyForCart")
    public ResponseEntity<ResponseObject> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
        try {
            String keys[] = {"cartId","userId","qty","price"};
            if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            short cartId = Short.parseShort(addCartRequest.get("cartId"));
            short userId =  Short.parseShort(addCartRequest.get("userId"));
            int qty =  Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            cartService.updatequantityByCartId(cartId, qty, price);
            List<Cart> obj = cartService.getCartByUserId(userId);
            Double totalAmount = cartService.getTotalAmountForUser(userId);
            Integer totalQuantity = cartService.getTotalQuantityForUser(userId);
            Map<String, Object> response = new HashMap<>();
            response.put("cart", obj);
            response.put("totalAmount", totalAmount);
            response.put("totalQuantity", totalQuantity);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","update ok",response ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseObject("failed", "not ok", ""));
        }

    }


    @DeleteMapping("cart/removeProductFromCart")
    public ResponseEntity<ResponseObject> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
        try {
            String keys[] = {"userId","cartId"};
            if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {

            }
            short cartId = Short.parseShort(removeCartRequest.get("cartId"));
            short userId = Short.parseShort(removeCartRequest.get("userId"));
            List<Cart> obj = cartService.removeCartByUserId(cartId, userId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","delete ok", obj));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ResponseObject(e.getMessage(), "",""));
        }
    }

    @GetMapping("cart/getCartsByUserId/{id}")
    public ResponseEntity<?> getCartsByUserId(@PathVariable(name = "id") short id) {
        try {
//            String keys[] = {"userId"};
//            if(ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
//            }
//            short userId = Short.parseShort(getCartRequest.get("userId"));

            List<Cart> obj = cartService.getCartByUserId(id);
            Double totalAmount = cartService.getTotalAmountForUser(id);
            Integer totalQuantity = cartService.getTotalQuantityForUser(id);
            Map<String, Object> response = new HashMap<>();
            response.put("cart", obj);
            response.put("totalAmount", totalAmount);
            response.put("totalQuantity", totalQuantity);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "get ok", response));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ResponseObject(e.getMessage(), "", ""));
        }
    }
}
