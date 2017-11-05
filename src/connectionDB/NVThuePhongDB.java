package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ThongTinThuePhong;

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

	public static int ThemKhachHangMoi(String hoTenKH,String CMND, 
			String DiaChi,String QuocTich,String SDT, String user, String pass) {
	 
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spThemKhachHangMoi(?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, hoTenKH);
			cstmt.setString(2, CMND);
			cstmt.setString(3, DiaChi);
			cstmt.setString(4, QuocTich);
			cstmt.setString(5, SDT);		
			
			int k = cstmt.executeUpdate();
	        if (k >= 1)
	        	return k;            
	        
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
		return 0;
}
	
	public static int CapNhatKhachHang(String maKH,String hoTenKH,String CMND, 
			String DiaChi,String QuocTich,String SDT, String user, String pass) {
	 
	Connection conn=null;
	CallableStatement cstmt=null;
	
	try {
		conn=ConnectDB.ConnectDB_Role(user, pass);
		if (conn == null) {
			System.out.println("connect null");
            return 0;
        }
		String sql= "{call spCapNhatKhachHang(?,?,?,?,?,?)}";
		cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		cstmt.setString(1, maKH);
		cstmt.setString(2, hoTenKH);
		cstmt.setString(3, CMND);
		cstmt.setString(4, DiaChi);
		cstmt.setString(5, QuocTich);
		cstmt.setString(6, SDT);		
		
		int k = cstmt.executeUpdate();
        if (k >= 1)
        	return k;            
        
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
	return 0;
}
	
	
	public static int ThemChiTietThue(String maKH,String maPhong, String ngayNhanPhong, 
			String ngayTraPhong, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spThemChiTietThue(?,?,?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, maPhong);
			cstmt.setString(3, ngayNhanPhong);
			cstmt.setString(4, ngayTraPhong);
			
			
			int k = cstmt.executeUpdate();
            if (k >= 1)
                return k;
            
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
		return 0;
	}

	public static int XoaChiTietThue(String maKH,String maPhong, String ngayNhanPhong, 
			String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spXoaChiTietThue(?,?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, maPhong);
			cstmt.setString(3, ngayNhanPhong);
			
			
			int k = cstmt.executeUpdate();
            if (k >= 1)
                return k;
            
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
		return 0;
	}


	public static int HuyGiaoDichThuePhong(String maKH, String ngayNhanPhong, 
			String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spHuyGiaoDichThuePhong(?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, ngayNhanPhong);
			
			cstmt.executeUpdate();
            
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
		return 0;
	}

	public static int CapNhatChiTietThue(String maKH,String maPhong, 
			String ngayTraPhongCu,String ngayTraPhongMoi, String user, String pass) {
	 
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spCapNhatChiTietThue(?,?,?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, maPhong);
			cstmt.setString(3, ngayTraPhongCu);
			cstmt.setString(4, ngayTraPhongMoi);
			
			int k = cstmt.executeUpdate();
	        if (k >= 1)
	        	return k;            
	        
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
		return 0;
	}
	
	
	
	public static int HuyDonThuePhong(String maKH, String maPhong, String ngayNhanPhong, 
			String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			if (conn == null) {
				System.out.println("connect null");
	            return 0;
	        }
			String sql= "{call spHuyDonThuePhong(?,?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, maPhong);
			cstmt.setString(3, ngayNhanPhong);
			
			cstmt.executeUpdate();
            
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
		return 0;
	}

}

