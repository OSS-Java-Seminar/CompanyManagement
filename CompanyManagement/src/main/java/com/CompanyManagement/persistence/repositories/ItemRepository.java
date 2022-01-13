package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
