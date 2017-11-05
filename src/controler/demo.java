package controler;


import java.sql.SQLException;
import java.util.List;


import model.DanhSachPhongTrong;

public class demo {

	public demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		
//		Connection connection = ConnectDB.getConnect_sa();
//		if(connection != null)
//			System.out.println(connection + ": thanh cong");
//		else
//			System.out.println("Login khong thanh cong");
		
		
		List<DanhSachPhongTrong> list = connectionDB.NVTimPhongDB.NVTimPhong("2017-11-08", "2017-11-10", "sa", "12345678");
		
		System.out.println(list.get(1).getMaLoaiPhong());
		
	}

}
