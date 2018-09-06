package com.onestopshop.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class DbUtil {

	static Connection con;

	public static Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			
			ResourceBundle rb = ResourceBundle.getBundle("db", Locale.US);
			String jdbcUrl = rb.getString("url");
			String jdbcUserName = rb.getString("userName");
			String jdbcPassword = rb.getString("password");
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
		return con;
	}
}
