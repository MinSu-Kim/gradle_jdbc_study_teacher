package gradle_jdbc_study_teacher;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import gradle_jdbc_study_teacher.jdbc.ConnectionProvider;
import gradle_jdbc_study_teacher.jdbc.LogUtil;

public class DBConnectionTest {
	
	@Test
	public void testConnection() {
		try {
			Connection con = ConnectionProvider.getConnection();
			LogUtil.prnLog("con = " + con);
			Assert.assertNotNull(con);
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보를 확인하삼~~!!");
		}
	}

}
