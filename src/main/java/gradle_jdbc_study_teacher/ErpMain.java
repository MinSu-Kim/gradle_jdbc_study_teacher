package gradle_jdbc_study_teacher;

import java.awt.EventQueue;
import java.util.Date;

public class ErpMain {

	public static void main(String[] args) {
		System.out.println(String.format("%tY", new Date()));
		String str = String.format("E%s%03d", String.format("%tY", new Date()).substring(1), 1);
		System.out.println(str);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
