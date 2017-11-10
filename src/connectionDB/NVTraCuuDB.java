package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThongTinKhachHang;
import model.ThongTinThuePhong;

public class NVTraCuuDB {

	public static List<ThongTinKhachHang> TraCuuThongTinKhachHang(String maTraCuu, String user, String pass) {
		Connection conn=null;
		CallableStatement cstmt=null;
		String maKH, hoTenKH, CMND, DiaChi, QuocTich, SDT;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return null;
	        }
			
			String sql= "{call spTraCuuThongTinKhachHang(?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTraCuu);
			ResultSet kq=cstmt.executeQuery();
			
			
			List<ThongTinKhachHang> thongtinKH= new ArrayList<ThongTinKhachHang>();
			while(kq.next()) {
				maKH=kq.getString("maKH");
				//System.out.println(maKH);
				hoTenKH=kq.getString("hoTenKH");
				//System.out.println(hoTenKH);
				CMND=kq.getString("CMND");
				//System.out.println(CMND);
				DiaChi=kq.getString("DiaChi");
				//System.out.println(DiaChi);
				QuocTich=kq.getString("QuocTich");
				//System.out.println(DiaChi);
				SDT=kq.getString("SDT");
				//System.out.println(DiaChi);
				
				thongtinKH.add(new ThongTinKhachHang(maKH, hoTenKH, CMND, DiaChi, QuocTich, SDT));	
				 
			}		
			
			kq.close();	
			return thongtinKH; 
			
		}catch (SQLException ex) {
			System.out.println("Loi");
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
	
	public static List<ThongTinThuePhong> TraCuuThongTinThuePhongHienTaiCuaKhachHang(String maKH, String user, String pass) {
		Connection conn=null;
		CallableStatement cstmt=null;
		String maKhachHang,loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong, maCodeDatPhong;
		float tienPhong;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
	            return null;
	        }
			
			String sql= "{call spTraCuuThongTinThuePhongHienTai(?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			ResultSet kq=cstmt.executeQuery();
			
			List<ThongTinThuePhong> thongTinThuePhong= new ArrayList<ThongTinThuePhong>();
			while(kq.next()) {
				maKhachHang=kq.getString("maKH");
				loaiPhong=kq.getString("loaiPhong");
				maPhong=kq.getString("maPhong");
				ngayNhanPhong=kq.getString("ngayNhanPhong");
				ngayTraPhong=kq.getString("ngayTraPhong");
				tienPhong=kq.getFloat("tienPhong");
				maCodeDatPhong=kq.getString("maCodeDatPhong");
				
				thongTinThuePhong.add(new ThongTinThuePhong(maKhachHang,loaiPhong, maPhong, ngayNhanPhong, 
									ngayTraPhong, tienPhong, maCodeDatPhong));
			}		
			kq.close();	
			return thongTinThuePhong; 
			
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
