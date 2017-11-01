package model;

public class DanhSachPhongTrong {

	String maPhong, maLoaiPhong, loaiPhong;
	float tienPhong;
	
	public DanhSachPhongTrong() {
	}
	
	public DanhSachPhongTrong(String maPhong, String maLoaiPhong, String loaiPhong, float tienPhong) {
		this.maPhong=maPhong;
		this.maLoaiPhong=maLoaiPhong;
		this.loaiPhong=loaiPhong;
		this.tienPhong=tienPhong;
	}
	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public float getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}
	
	

}
