package gradle_jdbc_study_teacher;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_jdbc_study_teacher.dao.DepartmentDao;
import gradle_jdbc_study_teacher.daoimpl.DepartmentDaoImpl;
import gradle_jdbc_study_teacher.dto.Department;
import gradle_jdbc_study_teacher.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	static DepartmentDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new DepartmentDaoImpl();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectDepartmentByAll() {
		List<Department> lists = dao.selectDepartmentByAll();
		for(Department d : lists) {
			LogUtil.prnLog(d);
		}
		Assert.assertNotEquals(0, lists.size());
	}

	@Test
	public void test02SelectDepartmentByNo() {
		Department searchDept = dao.selectDepartmentByNo(new Department(1));
		LogUtil.prnLog(searchDept);
		Assert.assertNotNull(searchDept);
	}
	
	@Test
	public void test03InsertDepartment() {
		Department newDept = new Department(5, "마케팅", 40);
		int res = dao.insertDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
	
	@Test
	public void test04UpdateDepartment() throws SQLException {
		Department newDept = new Department(5, "마케팅2", 60);
		int res = dao.updateDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
	
	
	@Test
	public void test05DeleteDepartment() throws SQLException {
		Department newDept = new Department(5);
		int res = dao.deleteDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
}