package gradle_jdbc_study_teacher.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gradle_jdbc_study_teacher.dto.Department;

@SuppressWarnings("serial")
public class PanelDepartment extends AbstractPanelContent<Department>{
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;

	public PanelDepartment() {
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "부서정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblDeptNo = new JLabel("부서 번호");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptNo);
		
		tfDeptNo = new JTextField();
		add(tfDeptNo);
		tfDeptNo.setColumns(10);
		
		JLabel lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);
		
		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		add(tfDeptName);
		
		JLabel lblFloor = new JLabel("위치(층)");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}
	
	
	public void clearTextField() {
		tfDeptNo.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
		if (!tfDeptNo.isEditable()) {
			tfDeptNo.setEditable(true);
		}
	}
	
	@Override
	public void setItem(Department dept) {
		tfDeptNo.setText(String.format("D%03d", dept.getDeptNo()));
		tfDeptName.setText(dept.getDeptName());
		tfFloor.setText(String.valueOf(dept.getFloor()));		
	}
	
	@Override
	public Department getItem() {
		int deptNo = Integer.parseInt(tfDeptNo.getText().trim().substring(1));
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}
	
	@Override
	public void clearComponent(int nextNo) {
		tfDeptNo.setText(String.format("D%03d", nextNo));
		tfDeptName.setText("");
		tfFloor.setText("");
		tfDeptNo.setEditable(false);
		/*
		 * if (!tfDeptNo.isEditable()) { tfDeptNo.setEditable(true); }
		 */	
	}
	
	@Override
	public JTextField getTfNo() {
		return tfDeptNo;
	}
	
	@Override
	public void setComponentAllEditable(boolean isEditable) {
		tfDeptNo.setEditable(isEditable);
		tfDeptName.setEditable(isEditable);
		tfFloor.setEditable(isEditable);
	}

}







