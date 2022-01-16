package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
