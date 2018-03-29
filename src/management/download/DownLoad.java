package management.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFileChooser;

public class DownLoad {
	
	public void download(){
	
		    Connection con = null;  
		    Statement st = null;  
		    ResultSet rs = null; 
		      
		    Calendar date=Calendar.getInstance();
		    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		    String str2=df.format(date.getTime());
		    
		    try {  
		          
		        Class.forName("oracle.jdbc.driver.OracleDriver");  
		          
		        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","xxxx");  
		          
		        st = con.createStatement();  
		          
		        String sql = "select * from master";
		        PreparedStatement pstmt = con.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        
		        JFileChooser fc = new JFileChooser() ;
		        fc.setSelectedFile(new File("���I�T�ǩ`��"+str2+".csv"));
		        fc.showSaveDialog(fc) ;
		        File f = fc.getSelectedFile() ;
		       
		        FileOutputStream fos = new FileOutputStream(f,true);
		        PrintStream p = new PrintStream(fos);
		        
		        while (rs.next()) {
		            System.out.println(rs.getString("ID") +","+rs.getString("W_ID") +"," +rs.getString("NAME") +","+rs.getString("COL"));// ��������ص���int���Ϳ�����getInt()
		            String sb = rs.getString("ID") +","+rs.getString("W_ID") +"," +rs.getString("NAME") +","+rs.getString("COL");
		            p.println(sb);
		        }
		        
		        p.close();
		        fos.flush();
		     
		    } catch (ClassNotFoundException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		    } catch (SQLException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		    } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
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
		       
