package model;

public class ThongTinDatPhong_NV {
	String maKD, loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong, nguoiHuy;
	int tinhTrang;
	float tienPhong;
	
	public ThongTinDatPhong_NV() {
	}

	public ThongTinDatPhong_NV(String maKD, String loaiPhong,String maPhong,String ngayNhanPhong,String ngayTraPhong,int tinhTrang, float tienPhong, String nguoiHuy)
	{
		this.maKD=maKD;
		this.loaiPhong=loaiPhong;
		this.maPhong=maPhong;
		this.ngayNhanPhong=ngayNhanPhong;
		this.ngayTraPhong=ngayTraPhong;
		this.tinhTrang=tinhTrang;
		this.tienPhong=tienPhong;
		this.nguoiHuy=nguoiHuy;
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

	public String getMaKD() {
		return maKD;
	}

	public void setMaKD(String maKD) {
		this.maKD = maKD;
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

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
