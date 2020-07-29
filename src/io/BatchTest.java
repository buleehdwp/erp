package io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.erp.test.common.Connector;

public class BatchTest {
	public static void main(String[] args) {
		Connection conn = Connector.open();
		long sTime = System.currentTimeMillis();
		String sql = "insert into batch_test(num, name) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 100000; i++) {
				ps.setInt(1, i);
				ps.setNString(2, "이름" + i);
				ps.addBatch();
				if (i % 1000 == 0) {
					System.out.println(i / 1000);
					ps.executeBatch();
					conn.commit();
					ps.clearBatch();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long eTime = System.currentTimeMillis();
		System.out.println("실행시간 : " + (eTime - sTime));

	}
}
