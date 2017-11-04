package model;


public class ThongTinKhachHang {

	String maKH, hoTenKH, CMND, DiaChi, QuocTich, SDT;
	public ThongTinKhachHang() {
	}
	public ThongTinKhachHang(String maKH,String hoTenKH,String CMND,String DiaChi,String QuocTich,String SDT)
	{
		this.maKH=maKH;
		this.hoTenKH=hoTenKH;
		this.CMND=CMND;
		this.DiaChi=DiaChi;
		this.QuocTich=QuocTich;
		this.SDT=SDT;
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
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getQuocTich() {
		return QuocTich;
	}
	public void setQuocTich(String quocTich) {
		QuocTich = quocTich;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	

}
