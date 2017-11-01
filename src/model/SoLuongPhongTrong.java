package model;

public class SoLuongPhongTrong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private int soPhongTrong;
	
	public SoLuongPhongTrong(String maLoaiPhong,String tenLoaiPhong,int soPhongTrong) {
		this.maLoaiPhong=maLoaiPhong;
		this.tenLoaiPhong=tenLoaiPhong;
		this.soPhongTrong=soPhongTrong;
	}
	
	public SoLuongPhongTrong() {}
	
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public int getSoPhongTrong() {
		return soPhongTrong;
	}

	public void setSoPhongTrong(int soPhongTrong) {
		this.soPhongTrong = soPhongTrong;
	}
	
}
