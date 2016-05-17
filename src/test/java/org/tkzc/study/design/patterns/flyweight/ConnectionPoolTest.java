package org.tkzc.study.design.patterns.flyweight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionPoolTest {

	@Test
	public void testConnectionPool() {
		ConnectionPool connpool = ConnectionPool.getInstance();
		String sql = "select * from useraccount";
		Connection conn0 = connpool.getConnection();
		try {
			PreparedStatement pst = conn0.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connpool.release();
		}
	}
}
