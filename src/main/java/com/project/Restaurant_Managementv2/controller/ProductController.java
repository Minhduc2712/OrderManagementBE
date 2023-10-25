package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.dto.product.ProductDto;
import com.project.Restaurant_Managementv2.form.ProductFormForCreating;
import com.project.Restaurant_Managementv2.form.ProductFormForUpdating;
import com.project.Restaurant_Managementv2.models.PaginationSortingResponse;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.service.ProductService;
import com.project.Restaurant_Managementv2.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("product/")
    public ResponseEntity<ResponseObject> createNewProduct(@RequestBody ProductFormForCreating productNewForm) {
        try{
            Product productNew = productService.createNewProduct(productNewForm);

            ProductDto productNewDto = new ProductDto();
            productNewDto.setId(productNew.getId());
            productNewDto.setName(productNew.getName());
            productNewDto.setCountry(productNew.getCountry());
            productNewDto.setImg(productNew.getImg());
            productNewDto.setPrice(productNew.getPrice());
            productNewDto.setRate(productNew.getRate());
            productNewDto.setCategoryName(productNew.getCategory().getName());

            try{
                List<Product> productListDB = productService.getAllProducts();
                List<ProductDto> productListDto = new ArrayList<>();

                for (Product productDB : productListDB) {
                    ProductDto productDto = new ProductDto();
                    productDto.setId(productDB.getId());
                    productDto.setName(productDB.getName());
                    productDto.setCountry(productDB.getCountry());
                    productDto.setImg(productDB.getImg());
                    productDto.setPrice(productDB.getPrice());
                    productDto.setRate(productDB.getRate());
                    productDto.setCategoryName(productDB.getCategory().getName());

                    productListDto.add(productDto);
                }
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Created product successfully",productListDto));
            }
            catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed","Cannot create new product",""));
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("failed","Cannot create new product",""));
        }
    }

    @GetMapping("product/")
    public ResponseEntity<ResponseObject> getAllProducts() {
        try{
            List<Product> productListDB = productService.getAllProducts();
            List<ProductDto> productListDto = new ArrayList<>();

            for (Product productDB : productListDB) {
                ProductDto productDto = new ProductDto();
                productDto.setId(productDB.getId());
                productDto.setName(productDB.getName());
                productDto.setCountry(productDB.getCountry());
                productDto.setImg(productDB.getImg());
                productDto.setPrice(productDB.getPrice());
                productDto.setRate(productDB.getRate());
                productDto.setCategoryName(productDB.getCategory().getName());

                productListDto.add(productDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Query product successfully",productListDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed","Cannot find product",""));
        }

    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") short id) {
        Product productDB = productService.getProductById(id);

        ProductDto productDto = new ProductDto();
        productDto.setId(productDB.getId());
        productDto.setName(productDB.getName());
        productDto.setCountry(productDB.getCountry());
        productDto.setImg(productDB.getImg());
        productDto.setPrice(productDB.getPrice());
        productDto.setRate(productDB.getRate());
        productDto.setCategoryName(productDB.getCategory().getName());

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") short id, @RequestBody ProductFormForUpdating productUpdateForm) {
        Product productUpdate = productService.updateProduct(id, productUpdateForm);

        ProductDto productUpdateDto = new ProductDto();
        productUpdateDto.setId(productUpdate.getId());
        productUpdateDto.setName(productUpdate.getName());
        productUpdateDto.setCountry(productUpdate.getCountry());
        productUpdateDto.setImg(productUpdate.getImg());
        productUpdateDto.setPrice(productUpdate.getPrice());
        productUpdateDto.setRate(productUpdate.getRate());
        productUpdateDto.setCategoryName(productUpdate.getCategory().getName());

        return new ResponseEntity<>(productUpdateDto, HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<ResponseObject> deleteProductById(@PathVariable(name = "id") short id) {

    Product productDelete = productService.getProductById(id);

    ProductDto productDeleteDto = new ProductDto();
    productDeleteDto.setId(productDelete.getId());
    productDeleteDto.setName(productDelete.getName());
    productDeleteDto.setCountry(productDelete.getCountry());
    productDeleteDto.setImg(productDelete.getImg());
    productDeleteDto.setPrice(productDelete.getPrice());
    productDeleteDto.setRate(productDelete.getRate());
    productDeleteDto.setCategoryName(productDelete.getCategory().getName());

    productService.deleteProductById(id);
        try{
            List<Product> productListDB = productService.getAllProducts();
            List<ProductDto> productListDto = new ArrayList<>();

            for (Product productDB : productListDB) {
                ProductDto productDto = new ProductDto();
                productDto.setId(productDB.getId());
                productDto.setName(productDB.getName());
                productDto.setCountry(productDB.getCountry());
                productDto.setImg(productDB.getImg());
                productDto.setPrice(productDB.getPrice());
                productDto.setRate(productDB.getRate());
                productDto.setCategoryName(productDB.getCategory().getName());

                productListDto.add(productDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Query product successfully",productListDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed","Cannot find product",""));
        }


    }
    @GetMapping("product")
    public PaginationSortingResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){

        return productService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        List<Product> results = productService.searchProducts(query);
        if (results.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(results);
    }
}
