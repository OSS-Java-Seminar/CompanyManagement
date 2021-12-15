package com.CompanyManagement.service;

import com.CompanyManagement.persistence.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component
@Service
public class ItemService {

    private final ItemRepository itemRepository;
}
