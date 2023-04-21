package phdhtl.cntt.model;

import java.sql.Date;

public class donhangModel {
	int madh;
	String masach;
	int soluong;
	float gia;
	Date ngaydat;
	Date ngaygiao;
	String makh;
	boolean trangthai;
	
	public donhangModel() {
		super();
	}
	
	
	public donhangModel(Date ngaydat, String makh) {
		super();
		this.ngaydat = ngaydat;
		this.makh = makh;
	}


	public donhangModel(String masach, int soluong, float gia, Date ngaydat, String makh) {
		super();
		this.masach = masach;
		this.soluong = soluong;
		this.gia = gia;
		this.ngaydat = ngaydat;
		this.makh = makh;
	}
	public donhangModel(int madh, String masach, int soluong, float gia, Date ngaydat, Date ngaygiao, String makh,
			boolean trangthai) {
		super();
		this.madh = madh;
		this.masach = masach;
		this.soluong = soluong;
		this.gia = gia;
		this.ngaydat = ngaydat;
		this.ngaygiao = ngaygiao;
		this.makh = makh;
		this.trangthai = trangthai;
	}
	public int getMadh() {
		return madh;
	}
	public void setMadh(int madh) {
		this.madh = madh;
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
	public Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}
	public Date getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(Date ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	
	

}