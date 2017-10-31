package model;

public class NguoiDung {
	
	private String maNV, hoTenNV, CMND, DiaChi, SDT, matKhau;
	Integer quyenTruyCap;
	
	
	
	public NguoiDung(String maNV,String hoTenNV,String CMND,String DiaChi,String SDT,String matKhau ) {
		this.maNV=maNV;
		this.hoTenNV=hoTenNV;
		this.CMND=CMND;
		this.DiaChi=DiaChi;
		this.SDT=SDT;
		this.matKhau=matKhau;
	}



	public String getMaNV() {
		return maNV;
	}



	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}



	public String getHoTenNV() {
		return hoTenNV;
	}



	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
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



	public String getSDT() {
		return SDT;
	}



	public void setSDT(String sDT) {
		SDT = sDT;
	}



	public String getMatKhau() {
		return matKhau;
	}



	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}



	public Integer getQuyenTruyCap() { 
		return quyenTruyCap;
	}



	public void setQuyenTruyCap(Integer quyenTruyCap) {
		this.quyenTruyCap = quyenTruyCap;
	}

	
	
}
