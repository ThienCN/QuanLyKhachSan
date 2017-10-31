package connectionDB;

import java.util.List;

import javax.swing.JOptionPane;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.NguoiDung;



public class NguoiDungDB {

	
	public static Statement stmt = null;
	public static CallableStatement cstmt = null;
	public static Connection conn;
	public static ResultSet kq;
	
	public static void loadNguoiDung()
	{
		conn=ConnectDB.getConnect_sa();
		if(conn == null)
		{
			return;
		}
		//
		try {
			String sql="SELECT * FROM dbo.NHANVIEN";
			stmt=conn.createStatement();
			kq=stmt.executeQuery(sql);
			List<NguoiDung> nguoiDung=new ArrayList<NguoiDung>();
			
			
			while(kq.next()) {
				
				
				
				//nguoiDung.add(new NguoiDung(kq.getString("maNV"), kq.getString("hoTen"), CMND, DiaChi, SDT, matKhau));
			}
			
			kq.close();
		}catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

	public static Integer checkDangNhap(String user, String pass, int role) {		
		int flag = 0;
		try {			
			conn=ConnectDB.getConnect_sa();
			if(conn == null)
				return null;
			//       
			cstmt = conn.prepareCall("{?=call fn_CheckDangNhap(?,?,?)}");
			
            cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
            cstmt.setString(2, user);
            cstmt.setString(3, pass);
            cstmt.setInt(4, 1);
            
            cstmt.execute();
            
            flag = cstmt.getInt(1);
            
            System.out.println(flag);
           

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
		return flag;
	}

}
