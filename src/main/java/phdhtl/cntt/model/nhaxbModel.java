package phdhtl.cntt.model;

public class nhaxbModel {
	String maxb;
	String tenxb;
	String diachi;
	String sdt;
	String email;
	
	
	
	public nhaxbModel() {
		super();
	}
	public nhaxbModel(String maxb, String tenxb, String diachi, String sdt, String email) {
		super();
		this.maxb = maxb;
		this.tenxb = tenxb;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	public String getMaxb() {
		return maxb;
	}
	public void setMaxb(String maxb) {
		this.maxb = maxb;
	}
	public String getTenxb() {
		return tenxb;
	}
	public void setTenxb(String tenxb) {
		this.tenxb = tenxb;
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
