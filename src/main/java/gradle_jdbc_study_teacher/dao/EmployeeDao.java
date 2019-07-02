package gradle_jdbc_study_teacher.dao;

import java.util.List;

import gradle_jdbc_study_teacher.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
	
	//소속 부서별 사원
	List<Employee> selectEmployeeByDno(int dno);
}
