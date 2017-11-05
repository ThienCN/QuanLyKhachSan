package model;

public class DanhSachPhongTrong {

	String maPhong, maLoaiPhong, loaiPhong;
	float tienPhong;
	
	public DanhSachPhongTrong() {
	}
	
	public DanhSachPhongTrong( String maLoaiPhong, String loaiPhong, String maPhong, float tienPhong) {
		this.maLoaiPhong=maLoaiPhong;
		this.loaiPhong=loaiPhong;
		this.maPhong=maPhong;
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
