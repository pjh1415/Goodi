package com.goodi.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class BMIdemo implements ActionListener {
 
 JFrame frame;
  JPanel jp1, jp2, jp3;
  JLabel jl1, jl2, jl4, jl5, jlR1, jlR2,jlim;
  JTextField jtf1, jtf3;
  JButton jb1, jb2, jb3;
  static Container container;
 /** BMI Status */
  private static final String BMI_GRADE = "BMI Grade";
  /** BMI Result */
  private static final String BMI_RESULT = "BMI Result";
  
 public BMIdemo() {//생성자
   // frame
   frame = new JFrame("Body Mass Index");
   // container
    container = frame.getContentPane(); //컨테이너 객체생성, 쟁반역할!
 
  /* Panel */
   jp1 = new JPanel();
   jp2 = new JPanel();
   jp3 = new JPanel();
   JPanel jp11 = new JPanel();
   JPanel jp12 = new JPanel();
   JPanel jp21 = new JPanel();
   JPanel jp22 = new JPanel();
 
  /* Label */
   jl1 = new JLabel("height :");
   jl2 = new JLabel("cm");
   jl4 = new JLabel("weight :");
   jl5 = new JLabel("kg");
   jlR1 = new JLabel(BMI_RESULT);
   jlR1.setForeground(Color.GRAY);//처음색
   jlR2 = new JLabel(BMI_GRADE);
   jlR2.setForeground(Color.GRAY);
 
  /* TextField */
   jtf1 = new JTextField(4);
   jtf3 = new JTextField(4);
 
  /* Button */
   jb1 = new JButton("BMI");
   jb2 = new JButton("Clear");
   jb3 = new JButton("Exit");
   
  /* ImageIcon & JLabel*/
   //ImageIcon bmibar = new ImageIcon("C:/Users/ju/workspace/miniProject/src/bar2.png");
   jlim = new JLabel("",JLabel.CENTER);//bmibar 올려질 라벨
   jlim.setVerticalTextPosition(JLabel.BOTTOM);
   jlim.setHorizontalTextPosition(JLabel.CENTER);
   
  jp11.add(jl1);
   jp11.add(jtf1);
   jp11.add(jl2);
   jp12.add(jl4);
   jp12.add(jtf3);
   jp12.add(jl5);
   jp21.add(jlR1); //결과
   jp22.add(jlR2); //등급
   
   jp1.setLayout(new GridLayout(4, 1));
   jp1.add(jp11);
   jp1.add(jp12);
   jp1.add(jp21);
   jp1.add(jp22);
  
   jp2.add(jlim); //이미지라벨
 
  jp3.add(jb1);
   jp3.add(jb2);
   jp3.add(jb3);
 
   container.add(jp1, BorderLayout.NORTH);//위치
   container.add(jlim,BorderLayout.CENTER);
   container.add(jp3, BorderLayout.SOUTH);
   
   //배경색변겅
   jp3.setBackground(Color.WHITE);
   container.setBackground(Color.WHITE);
   jp11.setBackground(Color.WHITE);
   jp12.setBackground(Color.WHITE);
   jp21.setBackground(Color.WHITE);
   jp22.setBackground(Color.WHITE);
 
  // ActionListener
   jb1.addActionListener(this);
   jb2.addActionListener(this);
   jb3.addActionListener(this);
 
  // Windows EXIT
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.pack();
 
  frame.setSize(480, 260);
   frame.setVisible(false);
  }
 
 public void setIcon(){
	 jlim.setIcon(new ImageIcon("src/aa/minibar.png")); 
 }
 
 public void actionPerformed(ActionEvent e) {
 
  if (e.getSource() == jb1) { //계산
    // calculation
    if(getCalculation()) setIcon();
    
 
  } else if (e.getSource() == jb2) { //새로고침
    // Clear
    getClear();
 
  } else if (e.getSource() == jb3) {//끝내기(창닫기)
    // EXIT
    System.exit(0);
   }
  }
 
 private boolean getCalculation() { //비만도계산
  boolean result = false;
  double height = 0;
   double weight = 0;
 
  String cm = jtf1.getText();
   String pounds = jtf3.getText();
 
  if (cm == null || "".equals(cm)) {
	  cm = "0";
   }
   height = (Double.valueOf(cm)) * 0.01;
 
  if (pounds == null || "".equals(pounds)) {
    pounds = "0";
   }
   weight = Double.valueOf(pounds);
 
  if (!checkError(height, weight)) {
    // BMI = Weight(kg) / (Height(cm) x Height(cm))
    double value = weight / Math.pow(height, 2); //몸무게/ 키*키
 
   value = (double) Math.round(value * 100) / 100; // 소수점 둘째자리까지
 
   setResult(value);
   result = true;
   }
  	return result;
  }
 
 private void setResult(double value) { //등급 결과값
 
  String status = "";
 
  if (18.5 >= value)
    status = "underweight 저체중";
   else if (23.0 >= value)
    status = "normal 정상";
   else if (25.0 >= value)
    status = "overweight 과체중";
   else if (30.0 >= value)
	status = "obesity 비만 ";
   else
    status = "extremely obese 고도비만";
 
  jlR1.setText("당신의 BMI 결과는 " + value);
   jlR1.setForeground(Color.RED);
 
  jlR2.setText("당신의 BMI 등급은 " + status);
   jlR2.setForeground(Color.BLUE);
  }
 
 private boolean checkError(double height, double weight) {//값을 넣지않고 BMI버튼눌렀을때
 
  if (height == 0 || weight == 0) {
 
   String[] message = { "값을 정확하게 입력하세요." };
    JOptionPane.showMessageDialog(null, message, "warning", JOptionPane.WARNING_MESSAGE);
    
 
   return true;
   }
 
  return false;
  }
 
 private void getClear() {//clear
 
  jtf1.setText("");
   jtf3.setText("");
   jlR1.setText(BMI_RESULT);
   jlR1.setForeground(Color.GRAY);
   jlR2.setText(BMI_GRADE);
   jlR2.setForeground(Color.GRAY);
   jlim.setIcon(null);
  }
 
 public static void main(String[] args) {
   // main
   new BMIdemo();
  }//메인 메소드끝
 
}//클래스끝

