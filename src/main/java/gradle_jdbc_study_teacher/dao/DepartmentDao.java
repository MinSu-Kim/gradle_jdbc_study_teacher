package gradle_jdbc_study_teacher.dao;

import java.sql.SQLException;
import java.util.List;

import gradle_jdbc_study_teacher.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department dept) throws SQLException;
	int insertDepartment(Department dept) throws SQLException ;
	int deleteDepartment(Department dept) throws SQLException;
	int updateDepartment(Department dept) throws SQLException;
}
