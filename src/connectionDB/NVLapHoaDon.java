package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class NVLapHoaDon {
	
	public static float TinhTienCoc(String maKD, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TinhTienCocChoMotHoaDon(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.FLOAT);
			cstmt.setString(2, maKD); 
			
			cstmt.execute();
			
			float tienCoc=cstmt.getFloat(1);
			
			return tienCoc;
			
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
		return 0; 
		
	}

	public static String MaHoaDonMoi(String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TaoMaHoaDon()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String maHD =cstmt.getString(1);
			
			return maHD;
			
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

	public static float TinhTienDenBu(String maKH, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TinhTienDenBu(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.FLOAT);
			cstmt.setString(2, maKH); 
			
			cstmt.execute();
			
			float tienDenBu=cstmt.getFloat(1);
			
			return tienDenBu;
			
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
		return 0; 
		
	}

	public static float TinhTongTienPhong(String maKH, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TinhTongTienPhong(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.FLOAT);
			cstmt.setString(2, maKH);
			
			cstmt.execute();
			
			float tienPhong=cstmt.getFloat(1);
			
			return tienPhong;
			
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
		return 0; 
		
	}

	public static float TinhTongTienSuDungDichVu(String maKH, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_TinhTongTienSuDungDichVu(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.FLOAT);
			cstmt.setString(2, maKH);
			
			cstmt.execute();
			
			float tienSuDungDichVu=cstmt.getFloat(1);
			
			return tienSuDungDichVu;
			
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
		return 0; 
		
	}

	public static Date KiemTraXuatHoaDon(String maKH, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{?=call fn_KiemTraXuatHoaDon(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			cstmt.setString(2, maKH);
			
			cstmt.execute();
			
			Date ngayThanhToan =cstmt.getDate(1);
			
			return ngayThanhToan;
			
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

	public static void LapHoaDon(String maKH, float tongTienPhong, float tongTienSuDungDichVu,
			float tienDenBu, float tienDatCoc, float tongTienCanThanhToan, String user, String pass) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=ConnectDB.ConnectDB_Role(user, pass);
			
			cstmt=conn.prepareCall("{call spLapHoaDon(?,?,?,?,?,?,?)}");
			
			cstmt.setString(1, maKH);
			cstmt.setString(2, user);
			cstmt.setFloat(3, tienDatCoc);
			cstmt.setFloat(4, tienDenBu);
			cstmt.setFloat(5, tongTienPhong);
			cstmt.setFloat(6, tongTienSuDungDichVu);
			cstmt.setFloat(7, tongTienCanThanhToan);
			
			cstmt.execute();
			
			return;			
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
		return; 
		
	}

}
