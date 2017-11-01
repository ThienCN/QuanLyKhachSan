package connectionDB;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DanhSachPhongTrong;


public class NVTimPhongDB {

	public static List<DanhSachPhongTrong> NVTimPhong(String ngayNhanPhong, String ngayTraPhong, String user, String pass) throws SQLException
	{
		Connection conn=null;
		CallableStatement cstmt=null;
		String maPhong, maLoaiPhong, loaiPhong;
		float tienPhong;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
	            return null;
	        }
			
			String sql= "{call spNVTimPhong(?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, ngayNhanPhong);
			cstmt.setString(2, ngayTraPhong);
			
			ResultSet kq=cstmt.executeQuery();
			
			
			List<DanhSachPhongTrong> dsPhongTrong= new ArrayList<DanhSachPhongTrong>();
			while(kq.next()) {
				maPhong=kq.getString("maPhong");
				//System.out.println(maPhong);
				maLoaiPhong=kq.getString("maLoaiPhong");
				//System.out.println(maLoaiPhong);
				loaiPhong=kq.getString("loaiPhong");
				//System.out.println(loaiPhong);
				tienPhong=kq.getFloat("tienPhong");		
				//System.out.println(tienPhong);
				
				dsPhongTrong.add(new DanhSachPhongTrong(maPhong,maLoaiPhong,loaiPhong,tienPhong));				
				 
			}			
			
			kq.close();	
			return dsPhongTrong; 
			
		}finally {
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
	}
}
