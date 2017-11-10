package model;

public class ThongTinHoaDon {

	String maHD;
	
	float tienPhong, tienSuDungDichVu, tienDenBu, tienCoc;
	
	public ThongTinHoaDon() {
	}

	public ThongTinHoaDon(String maHD, float tienPhong,float tienSuDungDichVu,float tienDenBu,float tienCoc) {
		this.maHD=maHD;
		this.tienPhong=tienPhong;
		this.tienSuDungDichVu=tienSuDungDichVu;
		this.tienDenBu=tienDenBu;
		this.tienCoc=tienCoc;
	}
	

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public float getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}

	public float getTienSuDungDichVu() {
		return tienSuDungDichVu;
	}

	public void setTienSuDungDichVu(float tienSuDungDichVu) {
		this.tienSuDungDichVu = tienSuDungDichVu;
	}

	public float getTienDenBu() {
		return tienDenBu;
	}

	public void setTienDenBu(float tienDenBu) {
		this.tienDenBu = tienDenBu;
	}

	public float getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(float tienCoc) {
		this.tienCoc = tienCoc;
	}
	
	
	
}
