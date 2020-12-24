package connect;


	//数据库
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	public class Datahandle {
		private static Statement stat;
	private static void init() throws SQLException, ClassNotFoundException {
		  
		   // 注册 JDBC 驱动
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("服务器启动...");
	       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mymovie","root","123123");
	    // 执行查询
	         stat = conn.createStatement();
	       }
	       public static  Statement getStatement() throws SQLException, ClassNotFoundException{
	    	   if(stat==null)
	    		   init();
	    	   System.out.println("数据库已连接");
	    		   return stat;
	    	   
	       }
	       

	}
	   

