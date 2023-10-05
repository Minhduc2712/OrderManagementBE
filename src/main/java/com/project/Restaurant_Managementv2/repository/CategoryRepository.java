package com.project.Restaurant_Managementv2.repository;

import com.project.Restaurant_Managementv2.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Short> {
}
