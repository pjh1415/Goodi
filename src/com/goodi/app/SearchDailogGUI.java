package com.goodi.app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SearchDailogGUI extends JFrame implements ActionListener{

	JLabel lbi_id= new JLabel("<ID찾기>"); 
	JLabel lbi_name= new JLabel("이름");
	JLabel lbi_jumin= new JLabel("주민등록번호");
	JLabel lbi_a = new JLabel("-");
	JLabel lbi_b = new JLabel("-");


	JLabel lbp_pwd= new JLabel("<Pwd찾기>"); 
	JLabel lbp_id= new JLabel("ID");
	JLabel lbp_name= new JLabel("이름");  
	JLabel lbp_jumin= new JLabel("주민등록번호");


	JTextField id_name= new JTextField(""); 
	JTextField id_jumin1= new JTextField("");
	JTextField id_jumin2= new JTextField("");

	JTextField pwd_id= new JTextField(""); 
	JTextField pwd_name= new JTextField("");
	JTextField pwd_jumin1= new JTextField(""); 
	JTextField pwd_jumin2= new JTextField("");


	JButton btn_id= new JButton("ID찾기");
	JButton btn_cancel1= new JButton("취소");
	JButton btn_pwd= new JButton("Pwd찾기");
	JButton btn_cancel2= new JButton("취소");

	ConnectDAO dao = new ConnectDAO();
	Toolkit tool = Toolkit.getDefaultToolkit();
	Dimension s_size = tool.getScreenSize();  
	LoginGUI login;

	public SearchDailogGUI(LoginGUI login){
		super("ID/Pw찾기");

		Container ct = this.getContentPane();		
		ct.setBackground(Color.white);		
		ct.setLayout(null); 

		lbi_id.setBounds(30,30,80,30);
		lbi_id.setFont(new Font("맑은고딕체", Font.BOLD, 15));
		lbi_name.setBounds(40,60,80,20);
		lbi_jumin.setBounds(40,90,120,20);
		lbi_a.setBounds(208,95,10,10);
		lbi_a.setFont(new Font("돋움체", Font.BOLD, 10));
		lbi_b.setBounds(208,275,10,10);
		lbi_b.setFont(new Font("돋움체", Font.BOLD, 10));

		lbp_pwd.setBounds(30,180,80,30);
		lbp_pwd.setFont(new Font("맑은고딕체", Font.BOLD, 15));
		lbp_id.setBounds(40,210,80,20);
		lbp_name.setBounds(40,240,80,20);
		lbp_jumin.setBounds(40,270,80,20);

		id_name.setBounds(130,60,160,20);
		id_jumin1.setBounds(130,90,70,20);
		id_jumin2.setBounds(220,90,70,20);

		pwd_id.setBounds(130,210,160,20);
		pwd_name.setBounds(130,240,160,20);
		pwd_jumin1.setBounds(130,270,70,20);
		pwd_jumin2.setBounds(220,270,70,20);

		btn_id.setBounds(100,130,70,30);
		btn_cancel1.setBounds(190,130,70,30);

		btn_pwd.setBounds(100,310,70,30);
		btn_cancel2.setBounds(190,310,70,30);

		ct.add(btn_id);		ct.add(lbp_name);			ct.add(btn_pwd);		ct.add(btn_cancel2);
		ct.add(lbp_pwd); 	ct.add(lbp_id);				ct.add(lbp_jumin);		ct.add(btn_cancel1);	
		ct.add(lbi_id); 			ct.add(lbi_name); 			ct.add(lbi_jumin);	    
		         
				ct.add(lbi_a);				ct.add(lbi_b);
		
		ct.add(id_name);
		ct.add(id_jumin1); 
	    ct.add(id_jumin2);  
	    ct.add(pwd_id);	
	    ct.add(pwd_name);
	    ct.add(pwd_jumin1);
	    ct.add(pwd_jumin2);
	    
		this.setMinimumSize(new Dimension(350, 400)); 
		setBounds((s_size.width/2 - 350/2), (s_size.height/2 - 400/2), 350,400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn_id.addActionListener(this);
		btn_pwd.addActionListener(this);
		btn_cancel1.addActionListener(this);
		btn_cancel2.addActionListener(this);
	}


	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_id){

			if(id_name.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this,"이름을 입력해주세요.");
				id_name.requestFocus(); 
			}else if(id_jumin1.getText().trim().equals("") || id_jumin2.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this,"주민등록번호를 입력해주세요.");
			}else {
	
				dao.id_search(id_name.getText().trim(), id_jumin1.getText().trim()
					+"-"+id_jumin2.getText().trim());
				
			
			}

		}else if(e.getSource() == btn_pwd){
			if(pwd_id.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this,"아이디를 입력해주세요.");
				pwd_id.requestFocus();
			}else if(pwd_name.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this,"이름을 입력해주세요.");
				pwd_name.requestFocus();
			}else if(pwd_jumin1.getText().trim().equals("") ||pwd_jumin2.getText().trim().equals("") ){
				JOptionPane.showMessageDialog(this,"주민등록번호를 입력해주세요.");
			}else if(dao.pwd_search(pwd_id.getText().trim(), pwd_name.getText().trim(), pwd_jumin1.getText().trim()+"-"+pwd_jumin2.getText().trim())){}
		}else if(e.getSource() ==btn_cancel1){

			dispose();
		}else if(e.getSource() == btn_cancel2){

			dispose();
		}
	}
}
