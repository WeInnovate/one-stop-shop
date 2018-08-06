package com.onestopshop.dao;

import java.util.List;

import com.onestopshop.model.Item;

public interface ItemDao {

	Item getItem(long id);

	List<Item> getItems();

	int saveItem(Item item);

	int updateItem(Item item);

	int deleteItem(long id);

	boolean isItemExists(long id);
	
	void createItemTable();

}
