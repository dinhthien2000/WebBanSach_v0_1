package phdhtl.cntt.model;

public class theloaiModel {
	String matl;
	String tentl;
	
	
	public theloaiModel() {
		super();
	}
	public theloaiModel(String matl, String tentl) {
		super();
		this.matl = matl;
		this.tentl = tentl;
	}
	public String getMatl() {
		return matl;
	}
	public void setMatl(String matl) {
		this.matl = matl;
	}
	public String getTentl() {
		return tentl;
	}
	public void setTentl(String tentl) {
		this.tentl = tentl;
	}
	
}
