package com.cursosdedesarrollo.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class GoodItemApiAdapterRestController {

    private final ItemClient itemClient;

    public GoodItemApiAdapterRestController(ItemClient itemClient) {
        this.itemClient = itemClient;
    }
    public Collection<Item> fallback() {
        return new ArrayList<>();
    }



    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/top-brands")
    public Collection<Item> goodItems() {
        return itemClient.readItems()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Item item) {
        return !item.getName().equals("Nike") &&
                !item.getName().equals("Adidas") &&
                !item.getName().equals("Reebok");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/listado")
    public Collection<Item> listItems() {
        ArrayList<Item> listado= new ArrayList<>();
        Collection<Item> coleccion=itemClient.readItems()
                .getContent();
        for (Item i : coleccion){
            listado.add(i);
        }
        return listado;
    }

    public Item fallbackItem() {
        return new Item();
    }
    @HystrixCommand(fallbackMethod = "fallbackItem")
    @GetMapping("/create")
    public Item createItem() {
        Item i= new Item();
        i.setName("Pepe");
        return itemClient.postItem(i)
                .getContent();
    }

    @HystrixCommand(fallbackMethod = "fallbackItem")
    @GetMapping("/read")
    public Item readItem() {
        return itemClient.readItem(new Long(1)).getContent();
    }

    @HystrixCommand(fallbackMethod = "fallbackItem")
    @GetMapping("/edit")
    public Item editItem() {
        Item i= new Item();
        i.setName("Pepe");
        return itemClient.editItem(new Long(1),i)
                .getContent();
    }
    @HystrixCommand(fallbackMethod = "fallbackItem")
    @GetMapping("/delete")
    public Item deleteItem() {
        return itemClient.deleteItem(new Long(1)).getContent();
    }

}