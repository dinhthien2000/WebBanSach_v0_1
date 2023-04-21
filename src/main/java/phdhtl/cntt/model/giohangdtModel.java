package phdhtl.cntt.model;

public class giohangdtModel {
	int magh;
	String masach;
	int soluong;
	float gia;
	String makh;
	Boolean trangthai;
	
	
	
	public giohangdtModel() {
		super();
	}
	public giohangdtModel(int magh, String masach, int soluong, float gia, String makh, Boolean trangthai) {
		super();
		this.magh = magh;
		this.masach = masach;
		this.soluong = soluong;
		this.gia = gia;
		this.makh = makh;
		this.trangthai = trangthai;
	}
	public int getMagh() {
		return magh;
	}
	public void setMagh(int magh) {
		this.magh = magh;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public Boolean getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}
	
	
}
