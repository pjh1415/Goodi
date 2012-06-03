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
	JToolBar tb1 = new JToolBar(); // 툴바1 컴포넌트 생성
	JToolBar tb2 = new JToolBar(); // 툴바2s
	JToolBar tb3 = new JToolBar();

	JTabbedPane tp = new JTabbedPane(); // 탭 컴포넌트 생성

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();

	JPanel p9 = new JPanel();

	JLabel la = new JLabel("로그인 정보가 없습니다.");
	JLabel la2 = new JLabel();

	JLabel la3 = new JLabel("ID");
	JLabel la4 = new JLabel("이름");
	JLabel la5 = new JLabel("주소");
	JLabel la6 = new JLabel("전화번호");

	// 툴바 버튼의 명칭 지정
	JButton btn1 = new JButton("정보 변경");
	JButton btn2 = new JButton("변경 확인");
	JButton btn3 = new JButton("회원 탈퇴");
	JButton btn4 = new JButton("체중 변화");
	JButton btn5 = new JButton("BMI지수");
	JButton btn6 = new JButton("로그아웃");
	JButton btn7 = new JButton("한주식단");
	JButton btn8 = new JButton("권장섭취영양소");

	// 패널 4와 5를 합친후 수직으로 나누겠다는 뜻
	JSplitPane jp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p4, p5);
	JSplitPane jp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p6, p7);

	TimeSeriesDemo demo;
	ConnectDAO dao = new ConnectDAO();

	PieChartDemo1 pcd;
	JPanel pie1;

	public UserGUI() {
		super("접속을 환영합니다^^");
		this.setEnabled(false);
		// this.login = login;

		new LoginGUI(this);

		jp.setDividerLocation(345);
		jp2.setDividerLocation(345);

		p4.setMinimumSize(new Dimension(400, 300));
		// 툴바 컴포넌트에 버튼 삽입
		tb1.add(btn1);
		tb1.add(btn2);
		tb1.add(btn3);
		tb2.add(btn4);
		tb2.add(btn5);
		tb3.add(btn7);
		tb3.add(btn8);

		p2.setLayout(new BorderLayout());
		p2.add(tb2, "North"); // 툴바2를 패널2에 삽입
		p2.add(jp, "Center"); // 그래프가 들어갈 패널 jp을 패널2에 넣음

		p3.setLayout(new BorderLayout());
		p3.add(tb3, "North");
		p3.add(jp2, "Center");

		// 탭 컴포넌트에 패널1,2,3을 넣음
		tp.add(p2, "체중변화");
		tp.add(p3, "식단관리");
		tp.add(p1, "개인정보변경");

		p8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p8.add(la);
		p8.add(btn6);

		add(p8, "North");
		add(tp, "Center");

		// add(p8,"East");

		setSize(800, 700); // 전체 창 크기

		// 창을 화면 가운데(x,y좌표에) 띄우겠다는 메소드
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
			la.setText("로그인 정보가 없습니다.");
			JOptionPane.showMessageDialog(this, "로그아웃되셨습니다.");

			new LoginGUI(this);
		} else if (e.getSource() == btn4) {
			System.out.println("버튼4");

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

}// 클래스 끝
