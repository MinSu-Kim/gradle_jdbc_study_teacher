package gradle_jdbc_study_teacher.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_jdbc_study_teacher.dao.EmployeeDao;
import gradle_jdbc_study_teacher.dto.Department;
import gradle_jdbc_study_teacher.dto.Employee;
import gradle_jdbc_study_teacher.dto.Title;
import gradle_jdbc_study_teacher.jdbc.ConnectionProvider;
import gradle_jdbc_study_teacher.jdbc.LogUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> selectEmployeeByAll() {
		List<Employee> lists = new ArrayList<Employee>();
		String sql = "select empno, empname, title, manager, salary, gender, dno, hire_date from employee;";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				lists.add(getEmployee(rs));
			}
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		} 
		return lists;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("empNo"), rs.getString("empName"), new Title(rs.getInt("title")), 
				new Employee(rs.getInt("manager")), rs.getInt("salary"), rs.getBoolean("gender"), 
				new Department(rs.getInt("dno")), 
				rs.getDate("hire_date"));
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		Employee searchEmployee = null;
		String sql = "select empno, empname, title, manager, salary, gender, dno, hire_date from employee where empno = ?";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, employee.getEmpNo());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					searchEmployee = getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		} 
		return searchEmployee;
	}

	@Override
	public int insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> selectEmployeeByDno(int dno) {
		// TODO Auto-generated method stub
		return null;
	}

}
