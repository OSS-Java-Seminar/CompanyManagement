package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Item;
import com.CompanyManagement.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable UUID id) {
        itemService.deleteItemById(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable UUID id, @RequestBody Item item) {
        itemService.updateItem(item, id);
    }

    @PostMapping("/assign/{itemId}/{categoryId}")
    public void assignCategoryToItem(@PathVariable UUID itemId, @PathVariable UUID categoryId)
    {
        itemService.assignCategoryToItem(itemId, categoryId);
    }

}
