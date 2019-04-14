package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.Exception;
import com.example.demo.annotation.Loggable;
import com.example.demo.annotation.MyException;
import com.example.demo.annotation.MyException2;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(produces = {"application/json"}, path = "/items")
    public Iterable<Item> getAllItems() {
        return itemService.getItems();
    }

    @Transactional
    @Loggable
    //@Exception
    @PostMapping(consumes = {"application/json"}, path = "/items/setted-items")
    public void setItem(@RequestBody Item item) throws MyException {
        itemService.addNew(item);
    }

    @Transactional
    @Loggable
    @Exception
    @PostMapping(consumes = {"application/json"}, path = "/items/setted-items2")
    public void setItem2(@RequestBody Item item) throws MyException2 {
        itemService.addNew2(item);
    }
}
