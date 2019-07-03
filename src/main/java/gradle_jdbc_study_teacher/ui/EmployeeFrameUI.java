package gradle_jdbc_study_teacher.ui;

import java.util.Date;

import javax.swing.JFrame;

import gradle_jdbc_study_teacher.dao.EmployeeDao;
import gradle_jdbc_study_teacher.daoimpl.EmployeeDaoImpl;
import gradle_jdbc_study_teacher.dto.Employee;
import gradle_jdbc_study_teacher.ui.content.PanelEmployee;
import gradle_jdbc_study_teacher.ui.list.EmployeeList;

@SuppressWarnings("serial")
public class EmployeeFrameUI extends AbstractFrameUI<Employee> {
	private EmployeeDao dao = new EmployeeDaoImpl();

	public EmployeeFrameUI() {
		reloadItemList();
		setTitle("사원관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		setpContent();
	}

	@Override
	protected void getContentPanel() {
		pContent = new PanelEmployee();

		int nextDeptNo = getNextNo();
		
		pContent.getTfNo().setText(String.format("E%s%03d", String.format("%tY", new Date()).substring(1), nextDeptNo));
		pContent.getTfNo().setEditable(false);
	}

	@Override
	protected void getListPanel() {
		pList = new EmployeeList("사원 목록");
		reloadItemList();
		pList.setItemList(itemLists);
		pList.reloadData();
	}

	@Override
	protected int getNextNo() {
		int nextDeptNo;
		if (itemLists.size()==0) {
			nextDeptNo = 0;
		}else {
			nextDeptNo = itemLists.get(itemLists.size()-1).getEmpNo();
		}
		return nextDeptNo+1;
	}

	@Override
	protected void reloadItemList() {
		itemLists = dao.selectEmployeeByAll();
	}

	@Override
	protected void actionContentUpdateUI() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void actionPerformedBtnUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void actionPerformedBtnAdd() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void actionPerformedBtnDelete() {
		// TODO Auto-generated method stub

	}

}
