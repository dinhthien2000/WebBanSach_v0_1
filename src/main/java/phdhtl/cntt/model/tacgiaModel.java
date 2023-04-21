package phdhtl.cntt.model;

public class tacgiaModel {
	String Matg;
	String tentg;
	String quoctich;
	
	
	
	
	public tacgiaModel() {
		super();
	}
	public tacgiaModel(String matg, String tentg, String quoctich) {
		super();
		Matg = matg;
		this.tentg = tentg;
		this.quoctich = quoctich;
	}
	public String getMatg() {
		return Matg;
	}
	public void setMatg(String matg) {
		Matg = matg;
	}
	public String getTentg() {
		return tentg;
	}
	public void setTentg(String tentg) {
		this.tentg = tentg;
	}
	public String getQuoctich() {
		return quoctich;
	}
	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	
	
}
