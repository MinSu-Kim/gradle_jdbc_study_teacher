package gradle_jdbc_study_teacher.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gradle_jdbc_study_teacher.ui.content.AbstractPanelContent;
import gradle_jdbc_study_teacher.ui.list.AbstractListPanel;

@SuppressWarnings("serial")
public abstract class AbstractFrameUI<T> extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pMain;
	protected AbstractPanelContent<T> pContent;
	protected AbstractListPanel<T> pList;
	protected JButton btnAdd;
	private JButton btnCancel;

	public AbstractFrameUI() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pMain = new JPanel();
		pMain.setLayout(new BorderLayout());
		contentPane.add(pMain, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void setpContent() {
		getContentPanel();
		getListPanel();
		
		pMain.add(this.pContent, BorderLayout.CENTER);
		contentPane.add(this.pList, BorderLayout.SOUTH);
	}

	protected abstract void getContentPanel();
	protected abstract void getListPanel();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			}
			if (e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate(e);
			}
		}
	}
	

	protected abstract void actionPerformedBtnUpdate(ActionEvent e);
	protected abstract void actionPerformedBtnAdd(ActionEvent e);
	protected abstract void actionPerformedBtnCancel(ActionEvent e);
}
