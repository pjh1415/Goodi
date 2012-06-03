package com.goodi.app;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class UserJoin extends JFrame implements ActionListener {

	JLabel lb_info = new JLabel("(*)는 필수입력 정보");
	JLabel lb_title = new JLabel("회  원  가  입");
	JLabel lb_id = new JLabel("아이디(*)");
	JLabel lb_pwd = new JLabel("비밀번호(*)");
	JLabel lb_pwd2 = new JLabel("비밀번호확인(*)");
	JLabel lb_name = new JLabel("이름(*)");
	JLabel lb_jumin = new JLabel("주민번호(*)");
	JLabel lb_age = new JLabel("나이(*)");
	JLabel lb_mail = new JLabel("E-Mail(*)");
	JLabel lb_phone = new JLabel("전화번호(*)");
	JLabel lb_addr = new JLabel("주소(*)");
	JLabel lb_move = new JLabel("평소운동량(*)");
	/*
	 * JLabel lb_weight = new JLabel("몸무게(*)"); JLabel lb_tall =new
	 * JLabel("키(*)"); JLabel lb_cm = new JLabel("Cm"); JLabel lb_kg = new
	 * JLabel("Kg");
	 */
	JLabel lb_sex = new JLabel("성별(*)");
	JLabel lb_a = new JLabel("-");
	JLabel lb_b = new JLabel("-");
	JLabel lb_c = new JLabel("-");
	JLabel lb_se = new JLabel("세");
	JLabel lb_aa = new JLabel("@");
	JLabel lb_addr2 = new JLabel("나머지주소");

	CheckboxGroup btn_sex = new CheckboxGroup();
	Checkbox btn_m = new Checkbox("남자", true, btn_sex);
	Checkbox btn_f = new Checkbox("여자", false, btn_sex);

	CheckboxGroup btn_move = new CheckboxGroup();
	Checkbox btn_low = new Checkbox("적음(주 1회이내)", true, btn_move);
	Checkbox btn_middle = new Checkbox("보통(주 3회이내)", false, btn_move);
	Checkbox btn_high = new Checkbox("많음(주 5회이상)", false, btn_move);

	JTextField t_id = new JTextField();
	JPasswordField t_pwd = new JPasswordField();
	JPasswordField t_pwd2 = new JPasswordField();
	JTextField t_name = new JTextField();
	JTextField t_mail = new JTextField("");
	JTextField t_addr = new JTextField("");
	JTextField t_addr2 = new JTextField("");
	JTextField t_phone = new JTextField("");
	JTextField t_phone2 = new JTextField("");
	JTextField t_jumin = new JTextField("");
	JTextField t_jumin2 = new JTextField("");
	/*
	 * JTextField t_tall= new JTextField(); JTextField t_weight = new
	 * JTextField();
	 */
	JTextField t_age = new JTextField();

	JButton btn_id = new JButton("ID중복확인");
	JButton btn_join = new JButton("가입");
	JButton btn_cancel = new JButton("취소");

	ConnectDAO dao;
	LoginGUI login;

	Toolkit tool = Toolkit.getDefaultToolkit();
	Dimension s_size = tool.getScreenSize();

	String phone_item[] = { "010", "02", "031", "032", "033", "041", "042",
			"043", "051", "052", "053", "054", "055", "061", "062", "063",
			"064" };

	JComboBox<String> pp = new JComboBox<String>(phone_item);

	String mail_item[] = { "naver.com", "nate.com", "hanmail.net", "gmail.com" };

	JComboBox<String> mm = new JComboBox<String>(mail_item);

	// TextArea phone_num = new TextArea(4,20);

	public UserJoin(LoginGUI login) {
		super("4조 건강관리 프로그램");
		this.login = login;

		Container ct = this.getContentPane();
		ct.setBackground(Color.white);
		ct.setLayout(null);

		lb_title.setForeground(new Color(100, 30, 30));
		lb_title.setFont(new Font("돋움체", Font.BOLD, 20));
		lb_title.setBounds(98, 0, 177, 33);

		lb_info.setBounds(209, 37, 120, 16);
		lb_info.setFont(new Font("돋움체", Font.BOLD, 10));

		lb_id.setBounds(15, 57, 87, 16);
		lb_pwd.setBounds(15, 87, 87, 16);
		lb_pwd2.setBounds(15, 117, 95, 15);
		lb_name.setBounds(15, 147, 87, 16);
		lb_jumin.setBounds(15, 177, 87, 15);
		lb_sex.setBounds(15, 207, 87, 15);
		lb_age.setBounds(15, 237, 87, 16);
		lb_phone.setBounds(15, 268, 87, 16);
		lb_mail.setBounds(15, 298, 87, 16);
		lb_addr.setBounds(15, 328, 87, 16);
		/*
		 * lb_tall.setBounds(15, 388, 87, 16); lb_weight.setBounds(15, 418, 87,
		 * 16);
		 */

		/*
		 * lb_cm.setBounds(253, 386, 87, 17); lb_kg.setBounds(253, 416, 87, 17);
		 */
		lb_move.setBounds(15, 388, 87, 16);
		lb_a.setBounds(205, 174, 15, 23);
		lb_a.setFont(new Font("돋움체", Font.BOLD, 12));
		lb_b.setBounds(170, 264, 15, 23);
		lb_b.setFont(new Font("돋움체", Font.BOLD, 12));
		lb_c.setBounds(245, 264, 15, 23);
		lb_c.setFont(new Font("돋움체", Font.BOLD, 12));

		lb_se.setBounds(230, 239, 15, 15);
		lb_se.setFont(new Font("휴먼옛체", Font.BOLD, 13));
		lb_aa.setBounds(200, 298, 15, 15);
		lb_aa.setFont(new Font("돋움체", Font.BOLD, 18));

		lb_addr2.setBounds(15, 358, 87, 16);
		lb_addr2.setFont(new Font("돋움체", Font.PLAIN, 10));
		t_id.setBounds(113, 54, 110, 23);

		t_pwd.setBounds(113, 84, 204, 23);
		t_pwd2.setBounds(113, 114, 204, 23);

		t_pwd2.setEditable(false);

		t_name.setBounds(113, 144, 204, 23);
		t_jumin.setBounds(113, 174, 84, 23);

		t_jumin2.setBounds(222, 174, 94, 23);

		t_age.setBounds(113, 234, 104, 23);

		t_phone.setBounds(182, 264, 60, 23);
		t_phone2.setBounds(258, 264, 60, 23);

		t_mail.setBounds(113, 294, 84, 23);

		t_addr.setBounds(113, 324, 204, 23);
		t_addr2.setBounds(113, 354, 204, 23);

		/*
		 * t_tall.setBounds(113, 384, 124, 23); t_weight.setBounds(113, 414,
		 * 124, 23);
		 */

		btn_low.setBounds(113, 384, 204, 23);
		btn_low.setFont(new Font("돋움체", Font.BOLD, 12));
		btn_low.setBackground(Color.WHITE);
		btn_middle.setBounds(113, 414, 204, 23);
		btn_middle.setFont(new Font("돋움체", Font.BOLD, 12));
		btn_middle.setBackground(Color.WHITE);
		btn_high.setBounds(113, 444, 204, 23);
		btn_high.setFont(new Font("돋움체", Font.BOLD, 12));
		btn_high.setBackground(Color.WHITE);

		btn_id.setBounds(225, 54, 91, 23);
		btn_id.setFont(new Font("돋움체", Font.BOLD, 10));

		btn_join.setBounds(98, 521, 70, 30);
		btn_join.setEnabled(false);

		btn_cancel.setBounds(185, 521, 70, 30);

		btn_m.setBounds(144, 204, 68, 23);
		btn_m.setBackground(Color.WHITE);
		btn_f.setBounds(224, 204, 68, 23);
		btn_f.setBackground(Color.WHITE);

		btn_m.setFont(new Font("돋움체", Font.BOLD, 12));

		btn_f.setFont(new Font("돋움체", Font.BOLD, 12));

		pp.setBounds(113, 264, 55, 23);
		mm.setBounds(220, 294, 100, 23);
		/*
		 * lb_cm.setFont(new Font("돋움체", Font.BOLD, 15)); lb_kg.setFont(new
		 * Font("돋움체", Font.BOLD, 15));
		 */

		ct.add(lb_id);
		ct.add(lb_pwd);
		ct.add(lb_name);
		ct.add(lb_pwd2);
		ct.add(t_id);
		ct.add(t_pwd);
		ct.add(t_pwd2);
		ct.add(t_name);
		ct.add(lb_mail);
		ct.add(lb_jumin);
		ct.add(lb_addr);
		ct.add(lb_phone);
		ct.add(t_jumin);
		ct.add(t_addr);
		ct.add(t_phone);
		ct.add(btn_id);
		ct.add(btn_join);
		ct.add(btn_cancel);
		ct.add(t_mail);
		ct.add(lb_title);
		/* ct.add(lb_tall); ct.add(lb_weight); ct.add(t_tall); ct.add(t_weight); */
		ct.add(lb_info);
		ct.add(lb_age);
		ct.add(t_age);
		ct.add(btn_m);
		ct.add(btn_f);
		ct.add(lb_sex); /* ct.add(lb_cm); ct.add(lb_kg); */
		ct.add(btn_low);
		ct.add(btn_middle);
		ct.add(btn_high);
		ct.add(lb_move);
		ct.add(pp);
		ct.add(mm);
		ct.add(t_jumin2);
		ct.add(lb_a);
		ct.add(lb_se);
		ct.add(t_phone2);
		ct.add(lb_b);
		ct.add(lb_c);
		ct.add(lb_aa);
		ct.add(lb_addr2);
		ct.add(t_addr2);

		this.setMinimumSize(new Dimension(350, 600));
		setBounds((s_size.width / 2 - 350 / 2), (s_size.height / 2 - 600 / 2),
				350, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btn_cancel.addActionListener(this);
		btn_id.addActionListener(this);
		btn_join.addActionListener(this);

		t_pwd2.addFocusListener(new MyFocusAdapter());

		t_id.addCaretListener(new GoodiCaretListener());
		t_pwd.addCaretListener(new GoodiCaretListener());
		t_pwd2.addCaretListener(new GoodiCaretListener());
		t_name.addCaretListener(new GoodiCaretListener());
		t_mail.addCaretListener(new GoodiCaretListener());
		t_jumin.addCaretListener(new GoodiCaretListener());
		t_addr.addCaretListener(new GoodiCaretListener());
		t_phone.addCaretListener(new GoodiCaretListener());
		/*
		 * t_tall.addCaretListener(new ddd()); t_weight.addCaretListener(new
		 * ddd());
		 */
	}

	public static void main(String[] args) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_cancel) {

			setVisible(false);
			login.setVisible(true);
			dispose();

		} else if (e.getSource() == btn_id) {
			dao = new ConnectDAO();
			System.out.println("중복체크버튼");
			if (t_id.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "ID를 입력해주세요.");
				t_id.requestFocus();

			} else if (dao.id_check(t_id.getText().trim())) {

				JOptionPane.showMessageDialog(this,
						"사용중인 아이디입니다.ㅠㅠ \n 다른아이디를 입력해주세요");
				t_id.setText("");
				t_id.requestFocus();
			} else {
				JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.^^");
				t_pwd.requestFocus();
			}
		} else if (e.getSource() == btn_join) {

			dao = new ConnectDAO();
			int result = 0;
			result = dao.memberInsert(this);
			if (result > 0) {
				this.setVisible(false);
				JOptionPane.showMessageDialog(this,
						"정상적으로 회원가입이 이루어졌습니다. \n 환영합니다.");
				login.setVisible(true);
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(this,
						"회원가입이 실패하였습니다.ㅠㅠ \n  다시 시도해주세요!");
				String s = "";
				t_id.setText(s);
				t_pwd.setText(s);
				t_pwd2.setText(s);
				t_name.setText(s);
				t_jumin.setText(s);
				t_age.setText(s);
				t_mail.setText(s);
				t_jumin.setText(s);
				t_addr.setText(s);
				t_phone.setText(s); /* t_tall.setText(s); t_weight.setText(s); */

				t_id.requestFocus();
			}
		}
	}

	class GoodiCaretListener implements CaretListener {
		@Override
		public void caretUpdate(CaretEvent e) {
			if (e.getSource().equals(t_pwd)) {
				if (t_pwd.getPassword().length > 0) {
					t_pwd2.setEditable(true);
					t_pwd2.setBackground(new Color(244, 245, 246));
				} else
					t_pwd2.setEditable(false);
			}

			if (t_name.getText().length() > 0 && t_id.getText().length() > 0
					&& t_pwd.getPassword().length > 0
					&& t_pwd2.getPassword().length > 0
					&& t_mail.getText().length() > 0
					&& t_phone.getText().length() > 0
					&& t_addr.getText().length() > 0
					&& t_jumin.getText().length() > 0
			/* && t_weight.getText().length() > 0 && t_tall.getText().length()>0 */) {
				btn_join.setEnabled(true);
			}
		}
	}

	class MyFocusAdapter extends FocusAdapter {
		public void focusLost(FocusEvent e) {
			boolean password = false;
			if (e.getSource().equals(t_pwd2)) {
				if (t_pwd2.getPassword().length > 0) {
					String pw = new String(t_pwd.getPassword());
					String pwr = new String(t_pwd2.getPassword());
					if (pw.equals(pwr))
						password = true;
				}
				if (password == false) {
					JOptionPane.showMessageDialog(UserJoin.this, "비밀번호틀림");
					Toolkit.getDefaultToolkit().beep();
					t_pwd.setText("");
					t_pwd2.setText("");
					t_pwd.grabFocus();
				}
			}
		}
	}

}