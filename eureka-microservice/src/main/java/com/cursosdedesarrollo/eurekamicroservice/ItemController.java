package com.cursosdedesarrollo.eurekamicroservice;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/api/items")
    public List<Item> getItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @GetMapping("/api/items/{itemId}")
    public Item getItem(@PathVariable(name="itemId")Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    @PostMapping("/api/items")
    public Item saveItem(@RequestBody Item item){
        itemRepository.save(item);
        return item;
    }

    @DeleteMapping("/api/items/{itemId}")
    public Item deleteItem(@PathVariable(name="itemId")Long id){
        Item i = itemRepository.findById(id).get();
        itemRepository.deleteById(id);
        return i;
    }

    @PutMapping("/api/item/{itemId}")
    public Item updateEmployee(@RequestBody Item item,
                               @PathVariable(name="itemId")Long id){
        itemRepository.save(item);
        return item;

    }

}

