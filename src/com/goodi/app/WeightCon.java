package com.goodi.app;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class WeightCon {

	
	Statement st;
	ResultSet rs;
	Connection con;
	PreparedStatement  ps;
	
	static int base;
	static int action;
	static int t_kcal;
	
 	static int rh=0;
	int rw=0;
	int ra=0;
	int raction=0;
	
	
	public WeightCon(){
		
		  try {
				Class.forName(DbProperties.DRIVER_NAME	);
				con=DriverManager.getConnection(DbProperties.URL,DbProperties.ID,DbProperties.PWD);
			} catch (ClassNotFoundException e) {
				System.out.println("�ε����");
			}catch(SQLException  se){
				System.out.println("�������");
			}
	        
		
	}
	//��� ���ڵ� ��������
	public void userSelectAll(DefaultTableModel tw_model){
		
		try {
			st=con.createStatement();
			rs=st.executeQuery("select *from userlist order by id");
			for(int i=0; i<tw_model.getRowCount();){
				tw_model.removeRow(0);
				} 
			while(rs.next()){
				Object data[]={
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				};
				tw_model.addRow(data);
			}
		}catch (SQLException e) {
			System.out.println("userselect all fail");
		}
	
		}
	//Į�θ� ��������
	//Į�θ�=���ʴ�緮+Ȱ����緮
	//���ʴ�緮=��)655.1+9.65*ü��+1.58*Ű-4.78*����
	   public  void kcal(){
	    	
	    	System.out.println("Į�θ�������");

	    		 		
						try {
						 	st=con.createStatement();
						 	rs=st.executeQuery
						 	("SELECT height,weight,age,action FROM phyinfo JOIN MEMBERDB ON phyinfo.id=memberDB.id");

							while(rs.next()){

					
						 	 rh=rs.getInt(1);
						 	 rw=rs.getInt(2);
						 	 ra=rs.getInt(3);
						 	 raction=rs.getInt(4);
						 	 
						 
							 System.out.println("rw="+rw);
	    			    	 System.out.println("ra="+ra);
	    			    	 System.out.println("rh="+rh);
						 	}
				 
		    			
	  	
		   			    	 base=(int) (655.1+9.65*rw+(1.58*rh)-(4.78*ra));
	    			    	 action=base*raction;
	    			    	 t_kcal=base+action;
	    			    	 System.out.println("rw="+rw);
	    			    	 System.out.println("ra="+ra);
	    			    	 System.out.println("rh="+rh);
	    			    	 System.out.println("base="+base);
	    			    	 System.out.println("action="+action);
	    			    	System.out.println("t_kcal="+t_kcal);
						} catch (SQLException e) {
							System.out.println(e+"=> kcal");
						}
	    			
	    	
	    }
	
	
	
	public static void main(String[] args) {
		
	}
}
