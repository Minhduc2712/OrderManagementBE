package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.form.ProductFormForCreating;
import com.project.Restaurant_Managementv2.form.ProductFormForUpdating;
import com.project.Restaurant_Managementv2.models.PaginationSortingResponse;
import com.project.Restaurant_Managementv2.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product createNewProduct(ProductFormForCreating productNewForm);

    public List<Product> getAllProducts();

    public List<Product> searchProducts(String keyword);

    public Product getProductById(short id);

    public Product updateProduct(short id, ProductFormForUpdating productUpdateForm);

    public void deleteProductById(short id);

    public PaginationSortingResponse getAllPosts(int pageNo, int pageSize, String SortBy, String sortDir);
}
