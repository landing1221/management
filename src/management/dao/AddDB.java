package management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class AddDB {
	
	public void add(String str5, String str6, String str7, String str8) {  
	    Connection con = null;  
	    Statement st = null;  
	    
	    try {  
	        //1.����oracle���ݿ�����  
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	        //2.��ȡ���ݿ�����  
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","xxxx");
	        st = con.createStatement();  
	        //4.ִ��sql����������  
	        String sql = "INSERT INTO master VALUES ('" + str5 + 
	        		"', '" + str6 + "', '" + str7 + "','"+ str8+"')";
	        st.executeUpdate(sql);
	        JOptionPane.showMessageDialog(null, "added on", "message added",JOptionPane.PLAIN_MESSAGE);
	        
	    } catch (ClassNotFoundException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } catch (SQLException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }finally{             
	        //�ر�st  
	        if(st != null){  
	            try {  
	                st.close();  
	            } catch (SQLException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	        //�ر�con  
	        if(con != null){  
	            try {  
	                con.close();  
	            } catch (SQLException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	}  
}
