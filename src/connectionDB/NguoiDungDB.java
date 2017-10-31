package connectionDB;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.NguoiDung;


public class NguoiDungDB {

	
	public static Statement stmt = null;
	public static Connection conn;
	public static ResultSet kq;
	
	public static void loadNguoiDung()
	{
		conn=ConnectDB.getConnect();
		if(conn == null)
		{
			return;
		}
		//
		try {
			String sql="SELECT * FROM dbo.NHANVIEN";
			stmt=conn.createStatement();
			kq=stmt.executeQuery(sql);
			List<NguoiDung> nguoiDung=new ArrayList<NguoiDung>();
			
			
			while(kq.next()) {
				
				
				
				//nguoiDung.add(new NguoiDung(kq.getString("maNV"), kq.getString("hoTen"), CMND, DiaChi, SDT, matKhau));
			}
			
			kq.close();
		}catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
}
