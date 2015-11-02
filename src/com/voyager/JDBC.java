package com.voyager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC {
	public static void main(String[] args) {
		try {
			// 1.注册数据库驱动
			DriverManager.registerDriver(new Driver());
			// 2.获取数据库连接
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "root", "root");
			// 3.获取传输器对象
			Statement statement = connection.createStatement();
			// 4.利用传输器传输SQL语句
			ResultSet resultSet = statement.executeQuery("select * from users");
			// 5.遍历结果集
			while (resultSet.next()) {
				String result = resultSet.getString(2);
				System.out.println(result);
			}
			// 6.关闭资源
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
