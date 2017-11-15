package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThongTinDatPhong_NV;
import model.ThongTinKhachDat;
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
	
	public static List<ThongTinKhachDat> TraCuuThongTinKhachDat(String maTraCuu, String user, String pass) {
		Connection conn=null;
		CallableStatement cstmt=null;
		String maKD, hoTenKD, CMND, DiaChi, QuocTich, SDT;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
	            return null;
	        }
			
			String sql= "{call spTraCuuThongTinKhachDat(?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTraCuu);
			ResultSet kq=cstmt.executeQuery();
			
			
			List<ThongTinKhachDat> thongtinKD= new ArrayList<ThongTinKhachDat>();
			while(kq.next()) {
				maKD=kq.getString("maKhachDat");
				//System.out.println(maKH);
				hoTenKD=kq.getString("HoTen");
				//System.out.println(hoTenKH);
				CMND=kq.getString("CMND");
				//System.out.println(CMND);
				DiaChi=kq.getString("DiaChi");
				//System.out.println(DiaChi);
				QuocTich=kq.getString("QuocTich");
				//System.out.println(DiaChi);
				SDT=kq.getString("SDT");
				//System.out.println(DiaChi);
				
				thongtinKD.add(new ThongTinKhachDat(maKD, hoTenKD, CMND, DiaChi, QuocTich, SDT));	
				 
			}		
			
			kq.close();	
			return thongtinKD; 
			
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

	public static List<ThongTinDatPhong_NV> TraCuuThongTinDatPhongHienTaiCuaKhachDat(String maKD, String user, String pass) {
		Connection conn=null;
		CallableStatement cstmt=null;
		String maKhachDat,loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong, nguoiHuy;
		int tinhTrang;
		float tienPhong;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
	            return null;
	        }
			
			String sql= "{call spTraCuuThongTinDatPhongHienTai(?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKD);
			ResultSet kq=cstmt.executeQuery();
			
			List<ThongTinDatPhong_NV> thongTinDatPhong_NV= new ArrayList<ThongTinDatPhong_NV>();
			while(kq.next()) {
				maKhachDat=kq.getString("maKhachDat");
				//System.out.println(maKhachDat);
				loaiPhong=kq.getString("loaiPhong");
				//System.out.println(loaiPhong);				
				maPhong=kq.getString("maPhong");
				//System.out.println(maPhong);
				ngayNhanPhong=kq.getString("ngayNhanPhong");
				//System.out.println(ngayNhanPhong);
				ngayTraPhong=kq.getString("ngayTraPhong");
				//System.out.println(ngayTraPhong);
				tinhTrang=kq.getInt("tinhTrang");
				//System.out.println(tinhTrang);
				tienPhong=kq.getFloat("tienPhong");
				//System.out.println(tienPhong);
				nguoiHuy=kq.getString("nguoiHuy");
				
				thongTinDatPhong_NV.add(new ThongTinDatPhong_NV(maKhachDat,loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong, tinhTrang, tienPhong, nguoiHuy));
			}		
			kq.close();	
			return thongTinDatPhong_NV; 
			
		}catch (SQLException ex) {
			//System.out.println("Loi");
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
