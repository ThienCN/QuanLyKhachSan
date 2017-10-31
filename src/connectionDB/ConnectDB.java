package connectionDB;

import java.sql.Connection; //Để kết nối đến DB
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection connect = null;
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYKHACHSAN;";
	public static String user, password;
	
	public static boolean ConnectDB_Role(String username, String pass) {
		try {
			//Đăng ký Driver của SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Lấy ra connection đến CSDL với 3 tham số truyền vào: url, user, pass
            connect=DriverManager.getConnection(url+"user="+username+";password="+pass); 
            
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Database Connect Failed.");
            return false;
        }
		return true;
	}
 
	public static Connection getConnect_sa() {	
				
		try {
			//Đăng ký Driver của SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Lấy ra connection đến CSDL với 3 tham số truyền vào: url, user, pass
            connect=DriverManager.getConnection(url+"user=sa;password=123");            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connect Failed.");
            return null;
        }
        return connect;
	}

}
