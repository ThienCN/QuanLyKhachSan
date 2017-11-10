package controler;


import java.sql.SQLException;
import java.util.List;


import model.DanhSachPhongTrong;
import java.util.List;

import connectionDB.NVLapHoaDon;
import connectionDB.NVThongKeDB;
import model.DanhSachPhongTrong;
import model.ThongKeThuePhong;
import model.ThongTinKhachHang;

public class demo {

	public demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		
		System.out.println(NVLapHoaDon.TinhTienCoc("KD1", "sa", "12345678"));
		System.out.println(NVLapHoaDon.TinhTienDenBu("KH1", "sa", "12345678"));
		System.out.println(NVLapHoaDon.TinhTongTienSuDungDichVu("KH1", "sa", "12345678"));
		System.out.println(NVLapHoaDon.TinhTongTienPhong("KH1", "sa", "12345678"));
		
	}

}
