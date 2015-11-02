package com.voyager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
		try {
			// 1.注册数据库驱动
			// DriverManager.registerDriver(new Driver());
			// 优化注册驱动采用反射方式
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接
			// JDBC基本写法
			// 协议:子协议//主机:端口/数据库?参数名:参数值
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
