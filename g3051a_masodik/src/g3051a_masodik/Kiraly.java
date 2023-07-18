package g3051a_masodik;

public class Kiraly {
	private String nev;
	private int koronazasEve;
	private int uralkodasVege;
	private String uralkodoHaz;
	
	public Kiraly(String sor) {
		setNev(sor.split("\s")[0]);
		int _k = Integer.parseInt(sor.split("\s")[1].split("-")[0]);
		int _u = Integer.parseInt(sor.split("\s")[1].split("-")[1]);
		setKoronazasEve(_k);
		setUralkodasVege(_u);
		setUralkodoHaz(sor.split("\s")[2]);
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getKoronazasEve() {
		return koronazasEve;
	}

	public void setKoronazasEve(int koronazasEve) {
		this.koronazasEve = koronazasEve;
	}

	public int getUralkodasVege() {
		return uralkodasVege;
	}

	public void setUralkodasVege(int uralkodasVege) {
		this.uralkodasVege = uralkodasVege;
	}

	public String getUralkodoHaz() {
		return uralkodoHaz;
	}

	public void setUralkodoHaz(String uralkodoHaz) {
		this.uralkodoHaz = uralkodoHaz;
	}
	
	
}
