package gradle_jdbc_study_teacher.dao;

import java.sql.SQLException;
import java.util.List;

import gradle_jdbc_study_teacher.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll() throws SQLException;
	Employee selectEmployeeByNo(Employee employee) throws SQLException;
	int insertEmployee(Employee employee) throws SQLException ;
	int deleteEmployee(Employee employee) throws SQLException;
	int updateEmployee(Employee employee) throws SQLException;
	
	//소속 부서별 사원
	List<Employee> selectEmployeeByDno(int dno) throws SQLException;
}
