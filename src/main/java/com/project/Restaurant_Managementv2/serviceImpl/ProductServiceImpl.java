package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.dto.product.ProductDto;
import com.project.Restaurant_Managementv2.form.ProductFormForCreating;
import com.project.Restaurant_Managementv2.form.ProductFormForUpdating;
import com.project.Restaurant_Managementv2.models.Category;
import com.project.Restaurant_Managementv2.models.PaginationSortingResponse;
import com.project.Restaurant_Managementv2.models.Product;
import com.project.Restaurant_Managementv2.repository.CategoryRepository;
import com.project.Restaurant_Managementv2.repository.ProductRepository;
import com.project.Restaurant_Managementv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createNewProduct(ProductFormForCreating productNewForm) {
        Category category = categoryRepository.getById(productNewForm.getCategoryId());
        Product product = new Product();
        product.setName(productNewForm.getName());
        product.setCountry(productNewForm.getCountry());
        product.setImg(productNewForm.getImg());
        product.setPrice(productNewForm.getPrice());
        product.setRate(productNewForm.getRate());
        product.setCategory(category);

        Product productNew = productRepository.save(product);

        return productNew;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(short id) {
        return productRepository.getById(id);
    }

    @Override
    public Product updateProduct(short id, ProductFormForUpdating productUpdateForm) {
        Product product = productRepository.getById(id);

        Category category = categoryRepository.getById(productUpdateForm.getCategoryId());
        product.setName(productUpdateForm.getName());
        product.setCountry(productUpdateForm.getCountry());
        product.setImg(productUpdateForm.getImg());
        product.setPrice(productUpdateForm.getPrice());
        product.setRate(productUpdateForm.getRate());
        product.setCategory(category);

        Product productUpdate= productRepository.save(product);
        return productUpdate;
    }

    @Override
    public void deleteProductById(short id) {
        productRepository.deleteById(id);
    }

    @Override
    public PaginationSortingResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> productsPage = productRepository.findAll(pageable);

        List<Product> listOfProducts = productsPage.getContent();

        List<ProductDto> content= listOfProducts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        PaginationSortingResponse postResponse = new PaginationSortingResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(productsPage.getNumber());
        postResponse.setPageSize(productsPage.getSize());
        postResponse.setTotalElements((int) productsPage.getTotalElements());
        postResponse.setTotalPages(productsPage.getTotalPages());
        postResponse.setLast(productsPage.isLast());


        return postResponse;
    }

    private ProductDto mapToDTO(Product post){
        ProductDto postDto = new ProductDto();
        postDto.setId(post.getId());
        postDto.setName(post.getName());
        postDto.setCountry(post.getCountry());
        postDto.setImg(post.getImg());
        postDto.setPrice(post.getPrice());
        postDto.setRate(post.getRate());
        postDto.setCategoryName(post.getCategory().getName());
        return postDto;
    }

    // convert DTO to entity
//    private Product mapToEntity(ProductDto postDto){
//        Product post = new Product();
//        post.setId(postDto.getId());
//        post.setName(postDto.getName());
//        post.setCountry(postDto.getCountry());
//        post.setImg(postDto.getImg());
//        post.setPrice(postDto.getPrice());
//        post.setRate(postDto.getRate());
//        post.setCategory(postDto.getCategoryName());
//        return post;
//    }
}
