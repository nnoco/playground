package com.nnoco.springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KUserDao extends UserDao {

	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook?useUnicode=true&characterEncoding=utf8", "spring", "book");
		
		return c;
	}

}
