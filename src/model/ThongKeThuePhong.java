package model;

public class ThongKeThuePhong {

	String maKH, hoTenKH;
	int soPhongDon, soPhongDoi, soPhongTapThe;
	
	public ThongKeThuePhong() {
	}
	
	public ThongKeThuePhong(String maKH,String hoTenKH,int soPhongDon,int soPhongDoi,int soPhongTapThe)
	{
		this.maKH=maKH;
		this.hoTenKH=hoTenKH;
		this.soPhongDon=soPhongDon;
		this.soPhongDoi=soPhongDoi;
		this.soPhongTapThe=soPhongTapThe;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
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
