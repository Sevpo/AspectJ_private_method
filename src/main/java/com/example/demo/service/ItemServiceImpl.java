package com.example.demo.service;

import com.example.demo.annotation.MyException;
import com.example.demo.annotation.MyException2;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void addNew(Item item) throws MyException {
        if(item.getPrice().compareTo(BigDecimal.ZERO) < 0){
            throw new MyException();
        }
        itemRepository.save(item);
    }

    @Override
    public void addNew2(Item item) throws MyException2{
        if(item.getPrice().compareTo(BigDecimal.ZERO) == 0){
            throw new MyException2();
        }
        itemRepository.save(item);
    }

    @Override
    public Collection<Item> getItems() {
        return itemRepository.findAllByItemIDContains();
    }
}
