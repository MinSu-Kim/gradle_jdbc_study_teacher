package gradle_jdbc_study_teacher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import gradle_jdbc_study_teacher.dao.DepartmentDao;
import gradle_jdbc_study_teacher.daoimpl.DepartmentDaoImpl;
import gradle_jdbc_study_teacher.dto.Department;
import gradle_jdbc_study_teacher.ui.content.PanelDepartment;
import gradle_jdbc_study_teacher.ui.list.DepartmentList;

@SuppressWarnings("serial")
public class DepartmentFrameUI extends AbstractFrameUI<Department> {
	private DepartmentDao dao = new DepartmentDaoImpl();

	public DepartmentFrameUI() {
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setpContent();
		
		
		addPopupMenu();
	}

	private void addPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntmPopUpdate = new JMenuItem("수정");
		mntmPopUpdate.addActionListener(popupListener);
		popupMenu.add(mntmPopUpdate);

		JMenuItem mntmPopDelete = new JMenuItem("삭제");
		mntmPopDelete.addActionListener(popupListener);
		popupMenu.add(mntmPopDelete);

		pList.setPopupMenu(popupMenu);
	}

	ActionListener popupListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	};
	
	
	@Override
	protected void getContentPanel() {
		pContent = new PanelDepartment();
	}

	@Override
	protected void getListPanel() {
		pList = new DepartmentList("부서 목록");
		pList.setItemList(dao.selectDepartmentByAll());
		pList.reloadData();
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Department dept = pContent.getItem();
		int res = dao.updateDepartment(dept);
		if (res == -1) {
			JOptionPane.showMessageDialog(null, dept + "수정 실패");
			return;
		}
		JOptionPane.showMessageDialog(null, dept + "수정 되었습니다.");
		refreshList();
		JOptionPane.showMessageDialog(null, e.getActionCommand());
		btnAdd.setText("추가");
		pContent.clearComponent();
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department dept = pContent.getItem();
		int res = dao.insertDepartment(dept);
		if (res == -1) {
			JOptionPane.showMessageDialog(null, dept + "추가 실패");
			return;
		}
		JOptionPane.showMessageDialog(null, dept + "추가 되었습니다.ㅇ");
		refreshList();
		pContent.clearComponent();
	}

	@Override
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearComponent();
	}

	private void refreshList() {
		pList.setItemList(dao.selectDepartmentByAll());
		pList.reloadData();
	}
}
