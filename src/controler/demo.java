package controler;


import java.sql.Connection;

import connectionDB.ConnectDB;

public class demo {

	public demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		Connection connection = connectDB.getConnect();
		System.out.println(connection);

	}

}
