package gradle_jdbc_study_teacher.jdbc;

import javax.sql.DataSource;

public class DataSourceProvider {
	public static DataSource getDataSource() {
		return MyDataSource.getInstance().getDataSource();
	}
}
