package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Item;
import com.CompanyManagement.persistence.repositories.CategoryRepository;
import com.CompanyManagement.persistence.repositories.ItemRepository;
import com.CompanyManagement.service.ItemService;
import com.CompanyManagement.web.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/items/")
public class ItemController {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemRepository itemRepository, CategoryRepository categoryRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.itemService = itemService;
    }

    @PostMapping
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping("search")
    public String searchByItemName(Model model, SearchParams searchParams) {
        model.addAttribute("items", itemService.getItems(searchParams.getSearchText()));
        model.addAttribute("searchParams", searchParams);
        return "item-list";
    }

    @GetMapping("listOfItems")
    public String getItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("searchParams", new SearchParams());
        return "item-list";
    }

    @PostMapping("addItem")
    public String addItem(@Valid Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "item-add";
        }
        itemRepository.save(item);
        return "redirect:listOfItems";
    }


    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable UUID id) {
        itemService.deleteItemById(id);
    }

    @GetMapping("delete/{id}")
    public String deleteItem(@PathVariable("id") UUID id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        itemService.deleteItemById(id);
        model.addAttribute("customers", itemRepository.findAll());
        return "item-list";
    }

    @GetMapping("addItem")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", categoryRepository.findAll());
        return "item-add";
    }


    @PutMapping("/{id}")
    public void updateItem(@PathVariable UUID id, @RequestBody Item item) {
        itemService.updateItem(item, id);
    }

    @PostMapping("update/{id}")
    public String updateItem(@PathVariable("id") UUID id, @Valid Item item, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            item.setId(id);
            return "update-item";
        }

        itemRepository.save(item);
        model.addAttribute("customers", itemRepository.findAll());
        return "item-list";
    }


    @PostMapping("/assign/{itemId}/{categoryId}")
    public void assignCategoryToItem(@PathVariable UUID itemId, @PathVariable UUID categoryId) {
        itemService.assignCategoryToItem(itemId, categoryId);
    }

}