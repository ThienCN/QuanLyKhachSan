package connectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
import model.ThongTinDatPhong;

public class KDDatPhongDB {
	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;

	public static String TaoMaKhachDat() {
		String maKhachDat = null;
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{?=call fn_TaoMaKhachDat()}");

			cstm.registerOutParameter(1, java.sql.Types.CHAR);

			cstm.execute();

			maKhachDat = cstm.getString(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return maKhachDat;
	}
	
	public static String ChonMaPhongChoKhachDat(String ngaynhanphong, String ngaytraphong, String maloaiphong) {
		String maPhong = null;
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{?=call fn_ChonMaPhongChoKhachDat(?,?,?)}");

			cstm.registerOutParameter(1, java.sql.Types.CHAR);
			cstm.setString(2, ngaynhanphong);
			cstm.setString(3, ngaytraphong);
			cstm.setString(4, maloaiphong);

			cstm.execute();

			maPhong = cstm.getString(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return maPhong;
	}
	
	public static float TienCocCuaMotPhong(String maphong, String ngaynhanphong, String ngaytraphong) {
		float tiencoc = 0;
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null)
				return 0;
			//
			cstm = cnn.prepareCall("{?=call fn_TinhTienThuePhongCuaMotPhong(?,?,?)}");

			cstm.registerOutParameter(1, java.sql.Types.FLOAT);
			cstm.setString(2, maphong);
			cstm.setString(3, ngaynhanphong);
			cstm.setString(4, ngaytraphong);

			cstm.execute();

			tiencoc = cstm.getFloat(1) * (float)0.1;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return tiencoc;
	}
	
	public static float TienThuePhongTheoLoaiPhong(String maloaiphong, int sophong, String ngaynhanphong, String ngaytraphong) {
		float tienthue = 0;
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null)
				return 0;
			//
			cstm = cnn.prepareCall("{?=call fn_TinhTienThuePhongTheoLoaiPhong(?,?,?,?)}");

			cstm.registerOutParameter(1, java.sql.Types.FLOAT);
			cstm.setString(2, maloaiphong);
			cstm.setInt(3, sophong);
			cstm.setString(4, ngaynhanphong);
			cstm.setString(5, ngaytraphong);

			cstm.execute();

			tienthue = cstm.getFloat(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return tienthue;
	}
	
	public static String ThemKhachDatMoi(String hotenKD, String CMND,
											String DiaChi, String QuocTich, String SDT) {
		
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null) {
				return null;
			}
			
			cstm = cnn.prepareCall("{call spThemKhachDatMoi(?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			cstm.setString(1, hotenKD);
			cstm.setString(2, CMND);
			cstm.setString(3, DiaChi);
			cstm.setString(4, QuocTich);
			cstm.setString(5, SDT);
			cstm.registerOutParameter(6, java.sql.Types.CHAR);
			
			
			cstm.executeUpdate();
	        if (cstm.getString(6)!=null)
	        	return cstm.getString(6);   
	        return null;
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Loi roi");
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}

	public static int ChiTietDatPhong(String maKD, String maPhong,
											String ngaynhanphong, String ngaytraphong, float tiencoc) {

		int k=0;
		
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null) {
				return k;
			}

			cstm = cnn.prepareCall("{call spThemChiTietDatPhong(?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			cstm.setString(1, maKD);
			cstm.setString(2, maPhong);
			cstm.setString(3, ngaynhanphong);
			cstm.setString(4, ngaytraphong);
			cstm.setFloat(5, tiencoc);
			cstm.registerOutParameter(6, java.sql.Types.INTEGER);

			cstm.executeUpdate();
			if (cstm.getInt(6)!=0)
	        	return cstm.getInt(6);   
	        return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Loi roi");
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}
}
