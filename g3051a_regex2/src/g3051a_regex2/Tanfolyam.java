package g3051a_regex2;

public class Tanfolyam {
	private String nev;
	private String terem;
	private String kezdes;
	private String vege;
	private String oraNeve;
	
	public Tanfolyam(String line) {
		String data[] = line.split(";");
		setNev(data[0]);
		setTerem(data[1]);
		setKezdes(data[2]);
		setVege(data[3]);
		setOraNeve(data[4]);
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		if(Main.nameValid(nev))
				this.nev = nev;
	}
	public String getTerem() {
		return terem;
	}
	public void setTerem(String terem) {
		this.terem = terem;
	}
	public String getKezdes() {
		return kezdes;
	}
	public void setKezdes(String kezdes) {
		if(Main.timeValid(kezdes))
			this.kezdes = kezdes;
	}
	public String getVege() {
		return vege;
	}
	public void setVege(String vege) {
		if(Main.timeValid(vege))
			this.vege = vege;
	}
	public String getOraNeve() {
		return oraNeve;
	}
	public void setOraNeve(String oraNeve) {
		this.oraNeve = oraNeve;
	}
	
	public boolean isValid() {
		return !(this.nev == null || this.kezdes == null || this.vege == null);
	}
	
	public int hosszPercben() {
		int kezdesOra = Integer.parseInt(kezdes.substring(0,2));
		int kezdesPerc = Integer.parseInt(kezdes.substring(3,5));
		int vegeOra = Integer.parseInt(vege.substring(0,2));
		int vegePerc = Integer.parseInt(vege.substring(3,5));
		
		return (vegeOra*60+vegePerc) - (kezdesOra*60+kezdesPerc);
	}

	@Override
	public String toString() {
		return "Tanfolyam [nev=" + nev + ", terem=" + terem + ", kezdes=" + kezdes + ", vege=" + vege + ", oraNeve="
				+ oraNeve + "]";
	}
	
	
}
