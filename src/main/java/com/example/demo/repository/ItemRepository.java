package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAllByItemIDContains();
}
