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
			// 1.ע�����ݿ�����
			DriverManager.registerDriver(new Driver());
			// 2.��ȡ���ݿ�����
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "root", "root");
			// 3.��ȡ����������
			Statement statement = connection.createStatement();
			// 4.���ô���������SQL���
			ResultSet resultSet = statement.executeQuery("select * from users");
			// 5.���������
			while (resultSet.next()) {
				String result = resultSet.getString(2);
				System.out.println(result);
			}
			// 6.�ر���Դ
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
