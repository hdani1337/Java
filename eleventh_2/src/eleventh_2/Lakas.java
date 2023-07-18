package eleventh_2;

public class Lakas 
{
	private int kerulet;
	private int terulet;
	private int szoba;
	private int ar;
	private String tulajdonos;
	private String nem;
	private String tipus;
	public Lakas(String line) {
		String[] adatok = line.split(",");
		kerulet = Integer.parseInt(adatok[0]);
		terulet = Integer.parseInt(adatok[1]);
		szoba = Integer.parseInt(adatok[2]);
		ar = Integer.parseInt(adatok[3]);
		tulajdonos = adatok[4];
		nem = adatok[5];
		tipus = adatok[6];
	}
	
	
	
	public int getKerulet() {
		return kerulet;
	}



	public void setKerulet(int kerulet) {
		this.kerulet = kerulet;
	}



	public int getTerulet() {
		return terulet;
	}



	public void setTerulet(int terulet) {
		this.terulet = terulet;
	}



	public int getSzoba() {
		return szoba;
	}



	public void setSzoba(int szoba) {
		this.szoba = szoba;
	}



	public int getAr() {
		return ar;
	}



	public void setAr(int ar) {
		this.ar = ar;
	}



	public String getTulajdonos() {
		return tulajdonos;
	}



	public void setTulajdonos(String tulajdonos) {
		this.tulajdonos = tulajdonos;
	}



	public String getNem() {
		return nem;
	}



	public void setNem(String nem) {
		this.nem = nem;
	}



	public String getTipus() {
		return tipus;
	}



	public void setTipus(String tipus) {
		this.tipus = tipus;
	}



	@Override
	public String toString() {
		return "Lakas [kerulet=" + kerulet + ", terulet=" + terulet + ", szoba=" + szoba + ", ar=" + ar
				+ ", tulajdonos=" + tulajdonos + ", nem=" + nem + ", tipus=" + tipus + "]";
	}
	
	
	
}
