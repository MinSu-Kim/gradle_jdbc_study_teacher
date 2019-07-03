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
		String sql = "select e.empno, e.empname, tno, tname, e.manager, m.empname as m_name, e.salary, e.gender, deptno, deptname, floor, e.hire_date "
				+ "from employee e left join title t on e.title = t.tno "
				+ "join department d on e.dno = d.deptno "
				+ "join employee m on e.manager = m.empno;";
		
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
		return new Employee(rs.getInt("empNo"), rs.getString("empName"), new Title(rs.getInt("tno"), rs.getString("tname")), 
				new Employee(rs.getInt("manager"), rs.getString("m_name")), rs.getInt("salary"), rs.getBoolean("gender"), 
				new Department(rs.getInt("deptno"), rs.getString("deptname"), rs.getInt("floor")), 
				rs.getDate("hire_date"));
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		Employee searchEmployee = null;
		String sql = "select e.empno, e.empname, tno, tname, e.manager, m.empname as m_name, e.salary, e.gender, deptno, deptname, floor, e.hire_date "
				+ "from employee e left join title t on e.title = t.tno "
				+ "join department d on e.dno = d.deptno "
				+ "join employee m on e.manager = m.empno where e.empno = ?";
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
