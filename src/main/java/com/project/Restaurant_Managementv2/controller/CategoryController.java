package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.dto.CategoryDto;
import com.project.Restaurant_Managementv2.models.Category;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<ResponseObject> getAllCategories(){
            List<Category> categoryListDB = categoryService.getAllCategories();
            List<CategoryDto> categoryListDto = new ArrayList<>();

            for(Category categoryDB: categoryListDB){
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(categoryDB.getId());
                categoryDto.setName(categoryDB.getName());

                categoryListDto.add(categoryDto);
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok","Query categories successfully",categoryListDto));
    }
}
