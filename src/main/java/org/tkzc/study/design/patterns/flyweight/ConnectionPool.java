package org.tkzc.study.design.patterns.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private List<Connection> pool;
	
	// 共有属性
	private String url = "jdbc:mysql://localhost:3306/itest";
	
	private String username = "root";
	
	private String password = "root";
	
	private String driverClassName = "com.mysql.jdbc.Driver";
	
	private int poolSize = 10;
	
	private static ConnectionPool instance = null;
	
	Connection conn = null;
	
	/**
	 * 构造方法, 做一些初始化工作
	 */
	private ConnectionPool() {
		pool = new ArrayList<Connection>(poolSize);
		try {
			for(int i=0; i<poolSize; i++) {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取线程池的实例
	 * @return
	 */
	public static ConnectionPool getInstance() {
		if(instance == null) {
			synchronized (ConnectionPool.class) {
				if(instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 返回连接到连接池
	 */
	public synchronized void release() {
		pool.add(conn);
	}
	
	/**
	 * 获取连接池中的一个连接
	 * @return
	 */
	public synchronized Connection getConnection() {
		if(pool.size() > 0) {
			conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}
}
