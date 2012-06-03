package com.goodi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConnectDAO {
	Connection con; 
	PreparedStatement ps; 
	Statement st; 
	ResultSet rs;

	
	ConnectDAO(){
		try{
			//�ε�
			Class.forName(DbProperties.DRIVER_NAME);

			con = DriverManager.getConnection(DbProperties.URL,DbProperties.ID,DbProperties.PWD);		
		}catch(ClassNotFoundException e){			
			System.out.println(e+"=> ����̹� �ε� ����");	
		}catch(SQLException e){
			System.out.println(e+"=> DB ���� ����");	
		}
	}

	public void dbClose(){ 	
		try{
			if(rs != null ) rs.close();
			if(ps != null ) ps.close();
			if(st != null ) st.close();

		}catch(Exception e){
			System.out.println(e+"=> dbClose fail");
		}			
	}

	public boolean id_check(String id){

		boolean idResult=false; 
		try {
			ps = con.prepareStatement("select * from memberDB where id=?");
			ps.setString(1, id.trim()); 
			rs=ps.executeQuery(); 

			if(rs.next()){  
				idResult = true; 
			}			
		} catch (SQLException e) {
			System.out.println(e+"==>ID �ߺ� üũ fail ");
		}finally{
			dbClose();
		}
		return idResult;
	}


	public boolean pwd_cheack(String id, String pwd){
		boolean check_Result=false; 
		try{
			ps = con.prepareStatement("select * from memberDB where id=? and pw=?");
			ps.setString(1, id); 
			ps.setString(2, pwd);
			rs=ps.executeQuery();

			if(rs.next()){
				check_Result = true;
			}

		}catch(SQLException e){

			System.out.println(e+"==>�н���ũ üũ fail");
		}finally{
			dbClose();
		}
		return check_Result;
	}

	public boolean id_search(String name, String jumin){
		boolean id_sch = false;

		try{
			ps = con.prepareStatement("select id from memberDB where name=? and jumin=?");
			ps.setString(1, name);
			ps.setString(2, jumin);
			rs=ps.executeQuery();
			
	
			if(rs.next()){
			JOptionPane.showMessageDialog(null,name+"���� ���̵��"+ "  ["+rs.getString(1)+"]  �Դϴ�");
			}else{
				JOptionPane.showMessageDialog(null,"ã���� ������ �����ϴ�. \n �ٽ� Ȯ�����ּ���!");
			}
		}catch(SQLException e){
			System.out.println(e+"==>���̵� ã�� fail");
		}finally{
			dbClose();
		}
		return id_sch;
		
	}
	
	public boolean pwd_search(String id, String name, String jumin){
		boolean pwd_sch = true;
		try{
			ps = con.prepareStatement("select password from memberDB where id=? and name=? and jumin=?");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, jumin);
			rs=ps.executeQuery();

			if(rs.next()){
				JOptionPane.showMessageDialog(null, id+"("+name+")  ���� ã���� ��й�ȣ��"+"  ["+rs.getString(1)+"]  �Դϴ�.");
			}else{
				JOptionPane.showMessageDialog(null,"�Է��Ͻ� ������ ��ġ�ϴ°��� �����ϴ� \n �ٽ� Ȯ�����ּ���^^!");
			}
			}catch(SQLException e){
				System.out.println(e+"==>�н����� ã�� fail");
			}finally{
				dbClose();
			}
		return pwd_sch;
	}
	
	public int memberInsert(UserJoin user){
		int result = 0;
		try {
			ps = con.prepareStatement("insert into memberDB values(?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, user.t_id.getText());
			ps.setString(2,new String(user.t_pwd.getPassword()));
			ps.setString(3, user.t_name.getText());
			ps.setString(4,user.t_jumin.getText()+"-"+user.t_jumin2.getText());
			ps.setString(5, user.btn_sex.getSelectedCheckbox().getLabel());
			ps.setString(6, user.t_age.getText());
			ps.setString(7, user.t_mail.getText()+"@"+user.mm.getSelectedItem());
			ps.setString(8, user.pp.getSelectedItem() +"-"+ user.t_phone.getText()+"-"+ user.t_phone2.getText());
			ps.setString(9, user.t_addr.getText()+user.t_addr2.getText());
			if(user.btn_move.getSelectedCheckbox()==user.btn_low){ps.setString(10, "1.3");
			}else if(user.btn_move.getSelectedCheckbox()==user.btn_middle) {ps.setString(10, "1.5");
			}else if(user.btn_move.getSelectedCheckbox()==user.btn_high){ps.setString(10, "1.75");
			}
		
			
			
//			ps.setString(10, user.btn_move.getSelectedCheckbox().)
			/*ps.setInt(10, Integer.parseInt(user.t_tall.getText()));
			ps.setInt(11, Integer.parseInt(user.t_weight.getText()));*/

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e+"=> ȸ������ fail");
		}finally{
			dbClose();
		}
		return result;				
	}	
	public void userSelectAll(DefaultTableModel t_model){
		try{
			st = con.createStatement();
			rs = st.executeQuery("select * from userlist order by id");
			for(int i = 0; i<t_model.getRowCount(); )
			{
				t_model.removeRow(0);
			}
			while(rs.next()){
				Object[] str = {
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				};
				t_model.addRow(str);
			}
		}catch(SQLException e){
			System.out.println(e+"=> userSelectAll fail");
		}finally{
			dbClose();
		}
	}

	public void access(LoginGUI login, UserGUI ug){
		try {
			ps = con.prepareStatement("select * from memberDB where id = ?");
			ps.setString(1,login.text1.getText().trim());
			rs = ps.executeQuery();

			if(rs.next()){
					if(rs.getString(2).equals(new String(login.text2.getPassword()).trim()) ){
						login.setVisible(false);
						login.dispose();
						ug.setEnabled(true);
						JOptionPane.showMessageDialog
						(login, rs.getString(3)+"�� ȯ���մϴ�");
						ug.la.setText(rs.getString(3)+"�� ������ . . .");
					}else{
						JOptionPane.showMessageDialog
						(login, "��й�ȣ�� ��ġ�����ʽ��ϴ� \n �ٽ�Ȯ�����ֽʽÿ�.");
					}
					
				}else {
					
					JOptionPane.showMessageDialog
					(login, "�α��� ������ �ùٸ��� �ʽ��ϴ� \n �ٽ�Ȯ�����ֽʽÿ�.");	
				}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbClose();
		}


	}

}//Ŭ���� ��
