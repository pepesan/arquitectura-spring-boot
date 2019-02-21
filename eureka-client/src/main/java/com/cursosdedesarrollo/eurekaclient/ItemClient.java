package com.cursosdedesarrollo.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("item-catalog-service")
interface ItemClient {

    @GetMapping("/items")
    Resources<Item> readItems();
}
