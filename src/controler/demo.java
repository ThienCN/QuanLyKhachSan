package controler;


import java.sql.Connection;

import connectionDB.ConnectDB;
import connectionDB.NVThuePhongDB;

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
		
		String maKH=NVThuePhongDB.MaKhachHangMoi("sa", "12345678");
		System.out.println(maKH);
		
	}

}
