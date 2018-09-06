package com.onestopshop.service;

import java.util.List;

import com.onestopshop.dao.ItemDao;
import com.onestopshop.dao.ItemDaoImpl;
import com.onestopshop.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public Item getItem(long id) {
		return itemDao.getItem(id);
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public int saveItem(Item item) {
		return itemDao.saveItem(item);
	}

	@Override
	public int updateItem(Item item) {
		return itemDao.updateItem(item);
	}

	@Override
	public int deleteItem(long id) {
		return itemDao.deleteItem(id);
	}

	@Override
	public boolean isItemExists(long id) {
		return itemDao.isItemExists(id);
	}

	@Override
	public void createItemTable() {
		itemDao.createItemTable();
	}

}
