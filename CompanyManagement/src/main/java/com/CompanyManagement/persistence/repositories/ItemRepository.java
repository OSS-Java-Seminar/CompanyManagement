package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {
}
