package com.inventory.inventory_management.repository;


import com.inventory.inventory_management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
