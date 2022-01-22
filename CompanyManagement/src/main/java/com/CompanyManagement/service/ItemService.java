package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Category;
import com.CompanyManagement.persistence.entities.Item;
import com.CompanyManagement.persistence.repositories.CategoryRepository;
import com.CompanyManagement.persistence.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
@Service
public class ItemService {

        private final ItemRepository itemRepository;
        private final CategoryRepository categoryRepository;

        public Item createItem(Item item) {
                return itemRepository.save(item);
        }

        public List<Item> getItems() {
                return (List<Item>) itemRepository.findAll();
        }

        public void deleteItemById(UUID id) {
                itemRepository.deleteById(id);
        }

        public void updateItem(Item newItem, UUID id) {
                var i = itemRepository.findById(id).orElse(null);

                i.setPrice(newItem.getPrice());
                i.setItemName(newItem.getItemName());

                itemRepository.save(i);
        }

        public void assignCategoryToItem(UUID itemId, UUID categoryId) {
                var item = itemRepository.findById(itemId).orElse(null);
                var category = categoryRepository.findById(categoryId).orElse(null);
                var list = new ArrayList<Category>();

                list.add(category);
                item.setCategories(list);

                itemRepository.save(item);
        }

}
