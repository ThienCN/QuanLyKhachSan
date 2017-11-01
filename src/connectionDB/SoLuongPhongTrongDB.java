package connectionDB;

import java.util.List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SoLuongPhongTrong;
import connectionDB.ConnectDB;

public class SoLuongPhongTrongDB {
	

	public static List<SoLuongPhongTrong> soPhongTrongTungLoai(String ngaynhanphong, String ngaytraphong) throws Exception {
		List<SoLuongPhongTrong> listphong = new ArrayList<SoLuongPhongTrong>();
		Connection cnn = null;
		CallableStatement stm = null;
		ResultSet rs = null;
		
		try {
			cnn = ConnectDB.getConnect_sa();
			if (cnn == null) {
				return null;
			}

			stm = cnn.prepareCall("{call spKhachDatTimPhong(?,?)}",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stm.setString(1, ngaynhanphong);
			stm.setString(2, ngaytraphong);

			rs = stm.executeQuery();
			while (rs.next()) {
				String a = rs.getString(1);
				String b = rs.getString(2);
				int c = rs.getInt(3);
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);

				SoLuongPhongTrong phong = new SoLuongPhongTrong(a, b, c);
				listphong.add(phong);
			}

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
		return listphong;
	}
}
