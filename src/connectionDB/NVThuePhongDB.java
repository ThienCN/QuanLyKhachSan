package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NVThuePhongDB {
	
	public static String MaKhachHangMoi(String user, String pass)
	{
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TaoMaKhachHang()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String maKH=cstmt.getString(1);
			
			return maKH;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return null;
	}

}
