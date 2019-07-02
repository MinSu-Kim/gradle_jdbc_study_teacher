package gradle_jdbc_study_teacher;

import java.awt.EventQueue;

import gradle_jdbc_study_teacher.ui.DepartmentFrameUI;

public class ErpMain {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(String.format("D%03d", 1));
					DepartmentFrameUI ui = new DepartmentFrameUI();
					ui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
