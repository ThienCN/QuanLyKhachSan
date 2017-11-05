package model;

public class ThongTinThuePhong {

	String maKH, loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong;
	float tienPhong;
	
	public ThongTinThuePhong() {
	}

	public ThongTinThuePhong(String maKH, String loaiPhong,String maPhong,String ngayNhanPhong,String ngayTraPhong, float tienPhong)
	{
		this.maKH=maKH;
		this.loaiPhong=loaiPhong;
		this.maPhong=maPhong;
		this.ngayNhanPhong=ngayNhanPhong;
		this.ngayTraPhong=ngayTraPhong;
		this.tienPhong=tienPhong;
	}

	public float getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(String ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public String getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(String ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}
	
	
}
