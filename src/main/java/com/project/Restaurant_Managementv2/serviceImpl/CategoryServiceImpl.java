package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.models.Category;
import com.project.Restaurant_Managementv2.repository.CategoryRepository;
import com.project.Restaurant_Managementv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
