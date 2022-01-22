package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Category;
import com.CompanyManagement.persistence.repositories.CategoryRepository;
import com.CompanyManagement.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    @PostMapping
    public void createCategories(@RequestBody Category category) {
        categoryService.createCategories(category);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryName}")
    public Category findCategoryByName(@PathVariable String categoryName) {
        return categoryService.findCategoryByName(categoryName);
    }
}
