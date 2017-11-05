package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThongKeThuePhong;

public class NVThongKeDB {

	public static List<ThongKeThuePhong> ThongKeGiaoDichThuePhong(String ngayBatDau, String ngayKetThuc, 
												String user, String pass) {
		Connection conn=null;
		CallableStatement cstmt=null;
		String maKH, hoTenKH;
		int soPhongDon = 0, soPhongDoi = 0, soPhongTapThe = 0;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return null;
	        }
			
			String sql= "{call spThongKeDSKHDangCoGiaoDichThuePhong(?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, ngayBatDau);
			cstmt.setString(2, ngayKetThuc);
			
			ResultSet kq=cstmt.executeQuery();
			
			List<ThongKeThuePhong> thongKeThuePhong=new ArrayList<ThongKeThuePhong>();
			
			while(kq.next()) {
				maKH=kq.getString("maKH");
				//System.out.println(maKH);
				hoTenKH=kq.getString("hoTenKH");
				//System.out.println(hoTenKH);
				
				sql = "{call spThongKeSoLoaiPhongThueCuaMotKHTrongKhoangNgay(?,?,?)}";
				cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				cstmt.setString(1, maKH);
				cstmt.setString(2, ngayBatDau);
				cstmt.setString(3, ngayKetThuc);
				
				ResultSet ketqua=cstmt.executeQuery();
				
				while(ketqua.next()) {
					if(ketqua.getString("loaiPhong").equals("Phòng đơn"))
						soPhongDon=ketqua.getInt("soPhong"); 
					else if(ketqua.getString("loaiPhong").equals("Phòng đôi"))
						soPhongDoi=ketqua.getInt("soPhong"); 
					else if(ketqua.getString("loaiPhong").equals("Phòng tập thể"))
						soPhongTapThe=ketqua.getInt("soPhong");
				}
				
				if(soPhongDoi!=0 || soPhongDon!=0 || soPhongTapThe != 0)
					thongKeThuePhong.add(new ThongKeThuePhong(maKH, hoTenKH, soPhongDon, soPhongDoi, soPhongTapThe));
				
				soPhongDon = 0;
				soPhongDoi = 0;
				soPhongTapThe = 0;
			}		
			
			kq.close();	
			return thongKeThuePhong;
	        
		}catch (SQLException ex) {
	        ex.printStackTrace();
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
		return null;
	}

	
	
}
