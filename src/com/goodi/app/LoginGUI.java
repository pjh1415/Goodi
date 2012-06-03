package com.goodi.app;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class LoginGUI extends JFrame implements ActionListener {
 /**
  * 필요한 컴퍼넌트 선언 및 생성
  */
  JButton log= new JButton("로그인");
  JButton btn1= new JButton("Id/Pw찾기");
  JButton btn2= new JButton("회원가입");
  
  JLabel lb_id = new JLabel("아이디 : ");
  JLabel lb_pwd = new JLabel("비밀번호 : ");
  
  JTextField text1= new JTextField("");
  JPasswordField text2= new JPasswordField("");
  
  ButtonGroup group = new ButtonGroup();
  JRadioButton user= new JRadioButton("일반회원" , true);
  JRadioButton  manager= new JRadioButton("관리자" , false);

  UserGUI ug;
  ConnectDAO dao = new ConnectDAO();
  
 public LoginGUI(UserGUI ug){
	
		super("건강관리 프로그램");
		 this.setEnabled(true);
		this.ug = ug;
		this.setAlwaysOnTop(true);
		setLayout(null);
		
		 setBackground(Color.white);
		
		user.setBounds( 85, 30, 90, 50);
		manager.setBounds(190, 30, 90, 50);
		group.add(user); group.add(manager);
		add(user);	add(manager);
	    text1.setBounds(115, 80, 145, 30);
	    text2.setBounds(115, 130, 145, 30);
		add(text1); add(text2);
	    
		lb_id.setBounds(40, 80, 80, 30);
		lb_id.setFont(new Font("돋움체", Font.BOLD, 12));
		lb_pwd.setBounds(40, 130, 80, 30);
		lb_pwd.setFont(new Font("돋움체", Font.BOLD, 12));
		add(lb_id); add(lb_pwd);
		
		log.setBounds(270, 80, 80, 80);
	    this.add(log);
	    	    
	    btn1.setBounds(85, 190, 100, 30);
	    btn2.setBounds(200, 190, 100, 30);
	    add(btn1); add(btn2);
				
	   
		setSize(400, 280);
		
		int x=(Toolkit.getDefaultToolkit().getScreenSize().width-getSize().width)/2;
		int y=(Toolkit.getDefaultToolkit().getScreenSize().height-getSize().height)/2;
		setLocation(x,y);
		
		setResizable(false);
		setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn2.addActionListener(this);
		log.addActionListener(this);
		btn1.addActionListener(this);
	}
		
	public static void main(String[] args) {
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==btn2){
		  try {
			  UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		    }  catch (Exception a) { }

		  new UserJoin(this); 
		  
	}else if (e.getSource() == log){
		dao = new ConnectDAO(); 
		dao.access(this,ug);
		
		
	}else if(e.getSource() == btn1){
			new SearchDailogGUI(this);
	}
	}
}
