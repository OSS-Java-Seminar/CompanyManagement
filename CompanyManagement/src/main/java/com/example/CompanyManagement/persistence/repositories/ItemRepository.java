package com.example.CompanyManagement.persistence.repositories;

import com.example.CompanyManagement.persistence.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {
}
