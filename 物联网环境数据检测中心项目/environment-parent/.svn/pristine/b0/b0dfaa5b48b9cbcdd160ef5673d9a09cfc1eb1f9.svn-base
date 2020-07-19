package com.briup.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class ConnecitonUtils {

	// 声明连接池
	private static DruidDataSource datasource = null;

	// 这样就可以让连接池只创建一个
	static {
		 
		// 读取properties
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
			
			datasource = new DruidDataSource();
			
			datasource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
			datasource.setUrl(properties.getProperty("jdbc.url"));
			datasource.setUsername(properties.getProperty("jdbc.username"));
			datasource.setPassword(properties.getProperty("jdbc.password"));
			
			datasource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.init")));
			
			datasource.setMaxActive(Integer.parseInt(properties.getProperty("jdbc.max")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(boolean autoCommit) throws SQLException {
		Connection connection = datasource.getConnection();
		
		connection.setAutoCommit(autoCommit);
		return connection;
	}
	
	public static Connection getConnection() throws SQLException {
		return getConnection(false);
	}
	
}
