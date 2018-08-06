package com.onestopshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.onestopshop.dao.util.DbUtil;
import com.onestopshop.model.Item;

public class ItemDaoImpl implements ItemDao {

	private String createItemTableQuery = "CREATE TABLE OSS_ITEM (ID BIGINT PRIMARY KEY, NAME VARCHAR, DESCRIPTION VARCHAR, QUANTITY NUMBER, PRICE DECIMAL)";
	private String getItemQuery = "SELECT * FROM OSS_ITEM WHERE ID = ?";
	private String saveItemQuery = "INSERT INTO OSS_ITEM VALUES(?, ?, ?, ?, ?)";

	Connection con;

	@Override
	public Item getItem(long id) {
		try (Connection con = DbUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(getItemQuery)) {
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				long itemId = rs.getLong(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				int quantity = rs.getInt(4);
				double price = rs.getDouble(5);
				return new Item(itemId, name, description, quantity, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> getItems() {
		return null;
	}

	@Override
	public int saveItem(Item item) {
		try (Connection con = DbUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(saveItemQuery)) {
			pstmt.setLong(1, item.getId());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getDescription());
			pstmt.setInt(4, item.getQuantity());
			pstmt.setDouble(5, item.getPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		return 0;
	}

	@Override
	public int deleteItem(long id) {
		return 0;
	}

	@Override
	public boolean isItemExists(long id) {
		return false;
	}

	@Override
	public void createItemTable() {
		try {
			con = DbUtil.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute(createItemTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
