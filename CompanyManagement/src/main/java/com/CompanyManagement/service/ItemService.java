package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.Item;
import com.CompanyManagement.persistence.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
@Service
public class ItemService {

        private final ItemRepository itemRepository;

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
}
