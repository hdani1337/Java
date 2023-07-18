package g3051a_exceptions;

public class Maraton {
	private String nev;
	private char nem;
	private String ido;
	
	public Maraton(String nev, char nem, String ido) throws MaratonException {
		this.nev = nev;
		this.nem = nem;
		this.ido = ido;
		if(!isValid()) throw new MaratonException(); 
	}
	
	public Maraton(String line) throws MaratonException {
		String[] data = line.split(",");
		setNev(data[0]);
		setNem(data[1].charAt(0));
		setIdo(data[2]);
		if(!MaratonUtilities.nameValid(nev)) throw new MaratonException("Hibás név: " + getNev()); 
		if(!MaratonUtilities.timeValid(ido)) throw new MaratonException("Hibás idő: " + getIdo()); 
	}
	
	public int hosszMPercben() {
		int ora = Integer.parseInt(ido.substring(0,2));
		int perc = Integer.parseInt(ido.substring(3,5));
		int mp = Integer.parseInt(ido.substring(6,8));
		return (ora*60*60+perc*60+mp);
	}
	
	public boolean isValid() {
		return MaratonUtilities.nameValid(nev) && MaratonUtilities.timeValid(ido);
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public char getNem() {
		return nem;
	}

	public void setNem(char nem) {
		this.nem = nem;
	}

	public String getIdo() {
		return ido;
	}

	public void setIdo(String ido) {
		this.ido = ido;
	}

	@Override
	public String toString() {
		String tempNem = "NULL";
		if(nem=='F') tempNem = "férfi";
		else if(nem=='N') tempNem = "nő";
		return nev + ", " + tempNem + ", " + ido;
	}
	
	
}
