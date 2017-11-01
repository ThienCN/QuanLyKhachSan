package connectionDB;

import java.sql.Connection; //Để kết nối đến DB
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection connect = null;
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYKHACHSAN;";
	
	
	//CẤM ĐỤNG ĐẾN FILE NÀY NHA CẢ NHÀ
	
	public static Connection ConnectDB_Role(String username, String pass) {
		try {
			//Đăng ký Driver của SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Lấy ra connection đến CSDL với 3 tham số truyền vào: url, user, pass
            connect=DriverManager.getConnection(url+"user="+username+";password="+pass); 
            
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Role Database Connect Failed.");
            return null;
        }
		return connect;
	}
 
	
	
	public static Connection getConnect_sa() {	
				
		try {
			//Đăng ký Driver của SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Lấy ra connection đến CSDL với 3 tham số truyền vào: url, user, pass
            connect=DriverManager.getConnection(url+"user=sa;password=12345678");            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SA Database Connect Failed.");
            return null;
        }
        return connect;
	}

}
