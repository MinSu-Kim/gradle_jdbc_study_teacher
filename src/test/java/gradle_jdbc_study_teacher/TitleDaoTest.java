package gradle_jdbc_study_teacher;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_jdbc_study_teacher.dao.TitleDao;
import gradle_jdbc_study_teacher.daoimpl.TitleDaoImpl;
import gradle_jdbc_study_teacher.dto.Title;
import gradle_jdbc_study_teacher.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	static TitleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new TitleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectTitleByAll() {
		List<Title> lists = dao.selectTitleByAll();
		for(Title t : lists) {
			LogUtil.prnLog(t);
		}
		Assert.assertNotEquals(0, lists.size());
	}

	@Test
	public void test02SelectTitleByNo() {
		Title searchTitle = dao.selectTitleByNo(new Title(1));
		LogUtil.prnLog(searchTitle);
		Assert.assertNotNull(searchTitle);
	}
	
	@Test
	public void test03InsertTitle() {
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertNotEquals(-1, res);
	}
	
	@Test
	public void test04UpdateTitle() throws SQLException {
		Title newTitle = new Title(6, "무기계약직");
		int res = dao.updateTitle(newTitle);
		Assert.assertNotEquals(-1, res);
	}
	
	
	@Test
	public void test05DeleteTitle() throws SQLException {
		Title newTitle = new Title(6);
		int res = dao.deleteTitle(newTitle);
		Assert.assertNotEquals(-1, res);
	}
}










