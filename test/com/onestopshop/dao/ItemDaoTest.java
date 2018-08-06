package com.onestopshop.dao;

import com.onestopshop.model.Item;

public class ItemDaoTest {

	public static void main(String[] args) {
		ItemDao itemDao = new ItemDaoImpl();
//		itemDao.createItemTable();
//		itemDao.saveItem(new Item(1001, "Laptop", "Touch Screen Laptop", 100, 500000.90));

		Item item  = itemDao.getItem(1001);
		System.out.println(item);
	}

}
