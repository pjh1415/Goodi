package com.goodi.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Graf extends JFrame{
	static JFrame jf=new JFrame();
	PieChartDemo1 pcd;
	BMIdemo bmi;
	JLabel label1; 
	JLabel label2;
	JLabel label3;
	String name="이채민";
	int cal=2600;
	TimeSeriesDemo tsd=new TimeSeriesDemo("");
	public Graf(){
		super("그래프");
		//파이차트  판넬로 생성
		JPanel pie1=pcd.createDemoPanel();
		JTabbedPane tab=new JTabbedPane();
		bmi=new BMIdemo();
		
		//라벨 붙이기
		label1=new JLabel(name+"님의 칼로리 권장량은 "+cal+"입니다");
		label1.setBounds(600, 0, 300, 100);
		label2=new JLabel(name +"님의 기초대사량은 "+cal+"입니다."); 
		label2.setBounds(600, 400, 300, 100);
		label3=new JLabel("한국 영양섭취 기준 테이블 붙ㄷ이는 곳");
		Font font=new Font("굴림",20,20);
		label1.setFont(font);
		
		//판넬 생성
		 JPanel p1=new JPanel();
		 JPanel p2=new JPanel();
		 p1.setBackground(Color.WHITE);
		 p1.setSize(400, 400);
		 p1.setLayout(new GridLayout(8,1));
		 JButton b1=new JButton("나의 필요열량은?");
		 JButton b2=new JButton("나의 활동대사량은?");
	 
		 p1.add(label1);
		 p1.add(label2);
		 p2.add(label3);
		 p1.add(b1);
		 p1.add(b2);
		 jf.add(p1,"East");
		 jf.add(p2,"South");
		 
		
	//	setContentPane(  tsd.getContentPane());
		// jf.getContentPane().add(pie1);
		 
		 tab.add("영양",pie1);
//		 tab.add("체중",tsd.chartPanel);
		 tab.add("BMI",bmi.container);
		 jf.add(tab);
		 
		 
				
	
		jf.setVisible(true);
		//jf.pack();
		jf.setSize(800,800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Graf();
	}
	
	
}
