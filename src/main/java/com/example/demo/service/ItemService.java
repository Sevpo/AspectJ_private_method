package com.example.demo.service;

import com.example.demo.annotation.MyException;
import com.example.demo.annotation.MyException2;
import com.example.demo.entity.Item;

import java.util.Collection;


public interface ItemService {
    void addNew(Item item) throws MyException;
    void addNew2(Item item) throws MyException2;
    Iterable<Item> getItems();
}
