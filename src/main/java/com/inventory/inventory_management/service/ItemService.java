package com.inventory.inventory_management.service;


import com.inventory.inventory_management.model.Item;
import com.inventory.inventory_management.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> saveAllItems(List<Item> items) {
        return itemRepository.saveAll(items);
    }


    public Item updateItem(Long id, Item item) {
        Item existing = itemRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(item.getName());
            existing.setQuantity(item.getQuantity());
            existing.setPrice(item.getPrice());
            return itemRepository.save(existing);
        }
        return null;
    }

    public List<Item> updateItemsBulk(List<Item> items) {
        List<Long> ids = new ArrayList<>();

        // collect all non-null IDs from the request
        for (Item item : items) {
            if (item.getId() != null) {
                ids.add(item.getId());
            }
        }

        // fetch existing items
        List<Item> existingItems = itemRepository.findAllById(ids);
        Set<Long> existingIds = new HashSet<>();
        for (Item existing : existingItems) {
            existingIds.add(existing.getId());
        }

        // filter only items with existing IDs
        List<Item> itemsToUpdate = new ArrayList<>();
        for (Item item : items) {
            if (existingIds.contains(item.getId())) {
                itemsToUpdate.add(item);
            }
        }

        return itemRepository.saveAll(itemsToUpdate);
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteItemsByIds(List<Long> ids) {
        itemRepository.deleteAllById(ids);
    }

}
