package com.inventory.inventory_management.controller;



import com.inventory.inventory_management.model.Item;
import com.inventory.inventory_management.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PostMapping("/bulk")
    public List<Item> createItemsBulk(@RequestBody List<Item> items) {
        return itemService.saveAllItems(items);
    }


    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @PutMapping("/bulk")
    public List<Item> updateItemsBulk(@RequestBody List<Item> items) {
        return itemService.updateItemsBulk(items);
    }


    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @DeleteMapping("/bulk")
    public void deleteItemsBulk(@RequestBody List<Long> ids) {
        itemService.deleteItemsByIds(ids);
    }

}

