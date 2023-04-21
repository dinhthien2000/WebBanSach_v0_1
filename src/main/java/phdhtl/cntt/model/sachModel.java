package phdhtl.cntt.model;

import java.sql.Date;

public class sachModel {
	String masach;
	String tensach;
	String anhbia;
	int sotrang;
	float gia;
	int soluong;
	Date ngaythem;
	String mota;
	String matg;
	String matl;
	String maxb;




	public sachModel() {

	}


	// add giữ nguyên img
	public sachModel(String masach, String tensach, int sotrang,float gia,int soluong, Date ngaythem,String mota, String matg, String matl,
			String maxb) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.sotrang = sotrang;
		this.gia = gia;
		this.soluong = soluong;
		this.ngaythem = ngaythem;
		this.mota = mota;
		this.matg = matg;
		this.matl = matl;
		this.maxb = maxb;
	}


	// add có thay đổi img
	public sachModel(String masach, String tensach, String anhbia, int sotrang, float gia,int soluong, Date ngaythem,String mota,String matg,
			String matl, String maxb) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.anhbia = anhbia;
		this.sotrang = sotrang;
		this.gia = gia;
		this.soluong = soluong;
		this.ngaythem = ngaythem;
		this.mota = mota;
		this.matg = matg;
		this.matl = matl;
		this.maxb = maxb;
	}
	
	
	// select tabkke sach 
//	public sachModel(String masach, String tensach, String anhbia, int sotrang, float gia, int soluong, Date ngaythem,
//			String mota, String matg, String matl, String maxb) {
//		super();
//		this.masach = masach;
//		this.tensach = tensach;
//		this.anhbia = anhbia;
//		this.sotrang = sotrang;
//		this.gia = gia;
//		this.Soluong = soluong;
//		this.ngaythem = ngaythem;
//		this.mota = mota;
//		this.matg = matg;
//		this.matl = matl;
//		this.maxb = maxb;
//	}


	public String getMasach() {
		return masach;
	}


	public void setMasach(String masach) {
		this.masach = masach;
	}


	public String getTensach() {
		return tensach;
	}


	public void setTensach(String tensach) {
		this.tensach = tensach;
	}


	public String getAnhbia() {
		return anhbia;
	}


	public void setAnhbia(String anhbia) {
		this.anhbia = anhbia;
	}


	public int getSotrang() {
		return sotrang;
	}


	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}


	public float getGia() {
		return gia;
	}


	public void setGia(float gia) {
		this.gia = gia;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public Date getNgaythem() {
		return ngaythem;
	}


	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	public String getMatg() {
		return matg;
	}


	public void setMatg(String matg) {
		this.matg = matg;
	}


	public String getMatl() {
		return matl;
	}


	public void setMatl(String matl) {
		this.matl = matl;
	}


	public String getMaxb() {
		return maxb;
	}


	public void setMaxb(String maxb) {
		this.maxb = maxb;
	}

	
	
	
	
	
	
}