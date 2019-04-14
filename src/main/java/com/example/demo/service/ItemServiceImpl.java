package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.MyException;
import com.example.demo.annotation.MyException2;
import com.example.demo.annotation.PrivateException;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	private final ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void addNew(Item item) throws MyException {
		addThisPrivate(item);
	}

	@PrivateException
	private void addThisPrivate(Item item) throws MyException{
		if (item.getPrice().compareTo(BigDecimal.ZERO) < 0) {
			throw new MyException("Holla from PRIVATE >>>>>>>>>>>>>>>!!!!!!!***************!!!!!!!<<<<<<<<<<<<<<<<<<<");
		}
		itemRepository.save(item);
	}


	@Override
	public void addNew2(Item item) throws MyException2 {
		if (item.getPrice().compareTo(BigDecimal.ZERO) == 0) {
			throw new MyException2("Hi");
		}
		itemRepository.save(item);
	}

	@Override
	public Iterable<Item> getItems() {
		return itemRepository.findAll();
	}
}
