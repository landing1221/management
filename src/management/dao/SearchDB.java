package management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import management.error.ErrorId;
import management.ui.UI;

@SuppressWarnings("serial")
public class SearchDB {
	
	ErrorId e = new ErrorId();
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void search(String str1,String str2,String str3,String str4) {  
	    Connection con = null;  
	    Statement st = null;  
	    ResultSet rs = null; 
	    DefaultTableModel model = new DefaultTableModel();
	   
	    try {  
	        //1.����oracle���ݿ�����  
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	        //2.��ȡ���ݿ�����  
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","xxxx");  
	        //3.��ȡִ��sql����ƽ̨  
	        st = con.createStatement();  
	        //4.ִ��sql����ȡ�����  
	        String sql = "select * from master where ID like ? and W_ID like ? and NAME like ? and COL like ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, "%"+str1+"%");
	        pstmt.setString(2, "%"+str2+"%");
	        pstmt.setString(3, "%"+str3+"%");
	        pstmt.setString(4, "%"+str4+"%");
	        rs = pstmt.executeQuery();
	        model.setColumnIdentifiers(new Object[] {"ID","W_ID","NAME","COL"});
	        //5.ѭ����ȡ���������  
	       
	        while(rs.next()){  
	        	 
	        	String ID = rs.getString("ID");
	        	
	        	String W_ID = rs.getString("W_ID");
	        	String NAME = rs.getString("NAME");
				String COL = rs.getString("COL");
				
				model.addRow(new Object[]{ID,W_ID,NAME,COL});
				
	        }
	       
	         if(UI.table.getRowCount()<=0) {
	        	 e.MSGAP18021601();
	         }
	        UI.table.setModel(model);
	        
	    } catch (ClassNotFoundException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } catch (SQLException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }finally{  
	        //�ر�rs  
	        if(rs != null){  
	            try {  
	                rs.close();  
	            } catch (SQLException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
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

    

