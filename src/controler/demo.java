package controler;


import java.util.List;

import model.DanhSachPhongTrong;
import model.ThongTinKhachHang;

public class demo {

	public demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
//		Connection connection = ConnectDB.getConnect_sa();
//		if(connection != null)
//			System.out.println(connection + ": thanh cong");
//		else
//			System.out.println("Login khong thanh cong");
		
//		String maKH=NVThuePhongDB.MaKhachHangMoi("sa", "12345678");
//		System.out.println(maKH);
		
		List<ThongTinKhachHang> dsPhongTrong= 
				connectionDB.NVTraCuuDB.TraCuuThongTinKhachHang("KH1", "sa", "12345678");
		
		
//		System.out.println(dsPhongTrong.get(1).getLoaiPhong());
//		System.out.println(dsPhongTrong.get(1).getMaLoaiPhong());
//		System.out.println(dsPhongTrong.get(1).getTienPhong());
		
//		int k = connectionDB.NVThuePhongDB.ThemKhachHangMoi("", "", "", "", "", "sa", "12345678");
//		System.out.println(k);
		
	}

}
