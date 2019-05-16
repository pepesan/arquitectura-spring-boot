package com.cursosdedesarrollo.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

@FeignClient("item-catalog-service")
interface ItemClient {

    @GetMapping("/api/items")
    Resources<Item> readItems();
    @PostMapping("/api/items")
    Resource<Item> postItem(@RequestBody Item item);
    @GetMapping("/api/items/{id}")
    Resource<Item> readItem(@PathVariable Long id);
    @PutMapping("/api/items/{id}")
    Resource<Item> editItem(@PathVariable Long id,@RequestBody Item item);
    @DeleteMapping("/api/items/{id}")
    Resource<Item> deleteItem(@PathVariable Long id);
}
