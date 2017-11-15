package model;

public class ThongKeDatPhong {

	String maKhachDat, hoTenKhachDat;
	int soPhongDon, soPhongDoi, soPhongTapThe;
	
	public ThongKeDatPhong() {
	}
	
	public ThongKeDatPhong(String maKhachDat,String hoTenKhachDat,int soPhongDon,int soPhongDoi,int soPhongTapThe)
	{
		this.maKhachDat=maKhachDat;
		this.hoTenKhachDat=hoTenKhachDat;
		this.soPhongDon=soPhongDon;
		this.soPhongDoi=soPhongDoi;
		this.soPhongTapThe=soPhongTapThe;
	}

	
	public String getMaKhachDat() {
		return maKhachDat;
	}

	public void setMaKhachDat(String maKhachDat) {
		this.maKhachDat = maKhachDat;
	}

	public String getHoTenKhachDat() {
		return hoTenKhachDat;
	}

	public void setHoTenKhachDat(String hoTenKhachDat) {
		this.hoTenKhachDat = hoTenKhachDat;
	}

	public int getSoPhongDon() {
		return soPhongDon;
	}

	public void setSoPhongDon(int soPhongDon) {
		this.soPhongDon = soPhongDon;
	}

	public int getSoPhongDoi() {
		return soPhongDoi;
	}

	public void setSoPhongDoi(int soPhongDoi) {
		this.soPhongDoi = soPhongDoi;
	}

	public int getSoPhongTapThe() {
		return soPhongTapThe;
	}

	public void setSoPhongTapThe(int soPhongTapThe) {
		this.soPhongTapThe = soPhongTapThe;
	}
	
}
