package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Category;
import com.CompanyManagement.persistence.repositories.CategoryRepository;
import com.CompanyManagement.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/name/{categoryName}")
    public Category findByCategoryName(@PathVariable String categoryName) {
        return categoryService.findCategoryByName(categoryName);
    }

    @GetMapping("/id/{categoryId}")
    public Optional<Category> findCategoryById(@PathVariable UUID categoryId) {
        return categoryService.findCategoryById(categoryId);
    }


}
