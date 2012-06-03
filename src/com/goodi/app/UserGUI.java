package com.goodi.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class UserGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1134960382082777146L;
	JToolBar tb1 = new JToolBar(); // ����1 ������Ʈ ����
	JToolBar tb2 = new JToolBar(); // ����2s
	JToolBar tb3 = new JToolBar();

	JTabbedPane tp = new JTabbedPane(); // �� ������Ʈ ����

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();

	JPanel p9 = new JPanel();

	JLabel la = new JLabel("�α��� ������ �����ϴ�.");
	JLabel la2 = new JLabel();

	JLabel la3 = new JLabel("ID");
	JLabel la4 = new JLabel("�̸�");
	JLabel la5 = new JLabel("�ּ�");
	JLabel la6 = new JLabel("��ȭ��ȣ");

	// ���� ��ư�� ��Ī ����
	JButton btn1 = new JButton("���� ����");
	JButton btn2 = new JButton("���� Ȯ��");
	JButton btn3 = new JButton("ȸ�� Ż��");
	JButton btn4 = new JButton("ü�� ��ȭ");
	JButton btn5 = new JButton("BMI����");
	JButton btn6 = new JButton("�α׾ƿ�");
	JButton btn7 = new JButton("���ֽĴ�");
	JButton btn8 = new JButton("���強�뿵���");

	// �г� 4�� 5�� ��ģ�� �������� �����ڴٴ� ��
	JSplitPane jp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p4, p5);
	JSplitPane jp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p6, p7);

	TimeSeriesDemo demo;
	ConnectDAO dao = new ConnectDAO();

	PieChartDemo1 pcd;
	JPanel pie1;

	public UserGUI() {
		super("������ ȯ���մϴ�^^");
		this.setEnabled(false);
		// this.login = login;

		new LoginGUI(this);

		jp.setDividerLocation(345);
		jp2.setDividerLocation(345);

		p4.setMinimumSize(new Dimension(400, 300));
		// ���� ������Ʈ�� ��ư ����
		tb1.add(btn1);
		tb1.add(btn2);
		tb1.add(btn3);
		tb2.add(btn4);
		tb2.add(btn5);
		tb3.add(btn7);
		tb3.add(btn8);

		p2.setLayout(new BorderLayout());
		p2.add(tb2, "North"); // ����2�� �г�2�� ����
		p2.add(jp, "Center"); // �׷����� �� �г� jp�� �г�2�� ����

		p3.setLayout(new BorderLayout());
		p3.add(tb3, "North");
		p3.add(jp2, "Center");

		// �� ������Ʈ�� �г�1,2,3�� ����
		tp.add(p2, "ü�ߺ�ȭ");
		tp.add(p3, "�Ĵܰ���");
		tp.add(p1, "������������");

		p8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p8.add(la);
		p8.add(btn6);

		add(p8, "North");
		add(tp, "Center");

		// add(p8,"East");

		setSize(800, 700); // ��ü â ũ��

		// â�� ȭ�� ���(x,y��ǥ��) ���ڴٴ� �޼ҵ�
		int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
		int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
		setLocation(x, y);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn6.addActionListener(this);
		btn4.addActionListener(this);
		btn8.addActionListener(this);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception a) {
		}

		new UserGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn6) {
			la.setText("�α��� ������ �����ϴ�.");
			JOptionPane.showMessageDialog(this, "�α׾ƿ��Ǽ̽��ϴ�.");

			new LoginGUI(this);
		} else if (e.getSource() == btn4) {
			System.out.println("��ư4");

			TimeSeriesDemo demo = new TimeSeriesDemo("aa");
			// ChartPanel cp = demo.TimeSerie();
			// jp.getLeftComponent()
			// p4.add(cp);
			JDialog tsd_jd = new JDialog(this);
			// .add(demo.chartPanel);

		} else if (e.getSource() == btn5) {
			// p5.add(new BMIdemo());
		} else if (e.getSource() == btn8) {

			JDialog jd = new JDialog(this);
			pie1 = pcd.createDemoPanel();
			jd.add(pie1);

			jd.setVisible(true);
			jd.setSize(400, 400);
			jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

	}

}// Ŭ���� ��
