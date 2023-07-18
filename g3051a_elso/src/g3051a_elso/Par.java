package g3051a_elso;

public class Par implements Comparable<Par>{
	private String lany;
	private String fiu;
	private String tanc;
	
	public Par() {
		setLany(null);
		setFiu(null);
		setTanc(null);
	}
	
	public Par(String sor) {
		setLany(sor.split("\s")[0]);
		setFiu(sor.split("\s")[1]);
		setTanc(sor.split("\s")[2]);
	}
	
	public Par(String lany, String fiu, String tanc) {
		this.lany = lany;
		this.fiu = fiu;
		this.tanc = tanc;
	}

	public String getLany() {
		return lany;
	}
	public void setLany(String lany) {
		this.lany = lany;
	}
	public String getFiu() {
		return fiu;
	}
	public void setFiu(String fiu) {
		this.fiu = fiu;
	}
	public String getTanc() {
		return tanc;
	}
	public void setTanc(String tanc) {
		this.tanc = tanc;
	}

	@Override
	public String toString() {
		return "Par(" + lany + ", " + fiu + ", " + tanc + ")";
	}

	@Override
	public int compareTo(Par o) {
		return this.tanc.compareTo(o.tanc);
	}
}
