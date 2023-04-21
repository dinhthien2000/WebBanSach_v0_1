package phdhtl.cntt.model;

public class userModel {
	String makh ;
	String taikhoan;
	String matkhau;
	String diachi;
	String sdt;
	String email;
	
	
	
	public userModel() {
		super();
	}
	public userModel(String makh, String taikhoan, String matkhau, String diachi, String sdt, String email) {
		super();
		this.makh = makh;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
