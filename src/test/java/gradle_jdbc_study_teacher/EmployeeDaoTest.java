package gradle_jdbc_study_teacher;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_jdbc_study_teacher.dao.EmployeeDao;
import gradle_jdbc_study_teacher.daoimpl.EmployeeDaoImpl;
import gradle_jdbc_study_teacher.dto.Department;
import gradle_jdbc_study_teacher.dto.Employee;
import gradle_jdbc_study_teacher.dto.Title;
import gradle_jdbc_study_teacher.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	static EmployeeDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new EmployeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectEmployeeByAll() {
		List<Employee> lists = dao.selectEmployeeByAll();
		for(Employee d : lists) {
			LogUtil.prnLog(d);
		}
		Assert.assertNotEquals(0, lists.size());
	}

	@Test
	public void test02SelectEmployeeByNo() {
		Employee searchEmp = dao.selectEmployeeByNo(new Employee(3427));
		LogUtil.prnLog(searchEmp);
		Assert.assertNotNull(searchEmp);
	}
	
	@Test
	public void test03InsertEmployee() {
		Employee newEmployee = new Employee(1004, "청하", new Title(4), new Employee(4377), 1500000, false, new Department(5), new Date());
		int res = dao.insertEmployee(newEmployee);
		Assert.assertNotEquals(-1, res);
	}
	
	@Test
	public void test04UpdateEmployee() throws SQLException {
		Employee newEmployee =new Employee(1004, "이유영", new Title(3), new Employee(3011), 2500000, true, new Department(4), new Date());
		int res = dao.updateEmployee(newEmployee);
		Assert.assertNotEquals(-1, res);
	}
	
	
	@Test
	public void test05DeleteEmployee() throws SQLException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee newEmployee = new Employee(1004);
		int res = dao.deleteEmployee(newEmployee);
		Assert.assertNotEquals(-1, res);
	}
}










