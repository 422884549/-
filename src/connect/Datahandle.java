package connect;


	//���ݿ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	public class Datahandle {
		private static Statement stat;
	private static void init() throws SQLException, ClassNotFoundException {
		  
		   // ע�� JDBC ����
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("����������...");
	       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mymovie","root","123123");
	    // ִ�в�ѯ
	         stat = conn.createStatement();
	       }
	       public static  Statement getStatement() throws SQLException, ClassNotFoundException{
	    	   if(stat==null)
	    		   init();
	    	   System.out.println("���ݿ�������");
	    		   return stat;
	    	   
	       }
	       

	}
	   

