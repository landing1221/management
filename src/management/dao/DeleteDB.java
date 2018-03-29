package management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import management.error.ErrorId;

public class DeleteDB {
	@SuppressWarnings("unused")
	ErrorId e = new ErrorId();
	public void removeSelectedFromTable(JTable from)
    {
		DefaultTableModel tm = (DefaultTableModel) from.getModel();
        int Selectedrow = from.getSelectedRow();
        String str = tm.getValueAt(Selectedrow, 0).toString();
        if(from.getSelectedRows().equals(null)) {
        	e.MSGAP18021606();
        }
        else {
        	tm.removeRow(Selectedrow);
        	 Connection con = null;  
     	    Statement st = null;  
     	    try {  
     	        //1.加载oracle数据库驱动  
     	        Class.forName("oracle.jdbc.driver.OracleDriver");  
     	        //2.获取数据库连接  
     	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","921221");  
     	        //3.获取执行sql语句的平台  
     	        st = con.createStatement();  
     	        //4.执行sql语句删除部门编号为40的部门  
     	        String sql = "delete from master where ID=?";
     	        PreparedStatement pstmt = con.prepareStatement(sql);
     	        pstmt.setString(1,str);
     	        
     	        pstmt.executeQuery();
     	         
     	        JOptionPane.showMessageDialog(null, "deleted", "message added",JOptionPane.PLAIN_MESSAGE);
     	    } catch (ClassNotFoundException e) {  
     	        // TODO Auto-generated catch block  
     	        e.printStackTrace();  
     	    } catch (SQLException e) {  
     	        // TODO Auto-generated catch block  
     	        e.printStackTrace();  
     	    }finally{             
     	        //关闭st  
     	        if(st != null){  
     	            try {  
     	                st.close();  
     	            } catch (SQLException e) {  
     	                // TODO Auto-generated catch block  
     	                e.printStackTrace();  
     	            }  
     	        }  
     	        //关闭con  
     	        if(con != null){  
     	            try {  
     	                con.close();  
     	            } catch (SQLException e) {  
     	                // TODO Auto-generated catch block  
     	                e.printStackTrace();  
     	            }  
     	        }  
        }}
       
       
}
	public void delete(String str) {  
	    Connection con = null;  
	    Statement st = null;  
	    try {  
	        //1.加载oracle数据库驱动  
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	        //2.获取数据库连接  
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","xxxx");  
	        //3.获取执行sql语句的平台  
	        st = con.createStatement();  
	        //4.执行sql语句删除部门编号为40的部门  
	        String sql = "delete from master where ID=?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, "%"+str+"%");
	        
	        pstmt.executeQuery();
	         
	        JOptionPane.showMessageDialog(null, "deleted", "message added",JOptionPane.PLAIN_MESSAGE);
	    } catch (ClassNotFoundException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } catch (SQLException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }finally{             
	        //关闭st  
	        if(st != null){  
	            try {  
	                st.close();  
	            } catch (SQLException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	        //关闭con  
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
