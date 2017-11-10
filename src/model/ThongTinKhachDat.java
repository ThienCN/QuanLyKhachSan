package model;

public class ThongTinKhachDat {
	String maKD, hoTenKD, CMND, DiaChi, QuocTich, SDT;
	public ThongTinKhachDat() {
	}
	public ThongTinKhachDat(String maKD,String hoTenKD,String CMND,String DiaChi,String QuocTich,String SDT)
	{
		this.maKD=maKD;
		this.hoTenKD=hoTenKD;
		this.CMND=CMND;
		this.DiaChi=DiaChi;
		this.QuocTich=QuocTich;
		this.SDT=SDT;
	}
	public String getMaKD() {
		return maKD;
	}
	public void setMaKD(String maKD) {
		this.maKD = maKD;
	}
	public String getHoTenKD() {
		return hoTenKD;
	}
	public void setHoTenKD(String hoTenKD) {
		this.hoTenKD = hoTenKD;
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
