package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Category;
import com.CompanyManagement.persistence.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Component
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategories(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
