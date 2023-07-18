package g3051a_telefonkonyv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefonszam implements Comparable<Telefonszam>{
	private String nev;
	private String telefonszam;
	
	public Telefonszam(String nev, String telefonszam) {
		this.nev = nev;
		this.telefonszam = telefonszam;
	}
	
	public Telefonszam(String line) {
		this.nev = line.split(",")[0];
		this.telefonszam = line.split(",")[1];
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getTelefonszam() {
		return telefonszam;
	}
	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}
	
	//06-20/50-60-170
	public String masikFormatum() {
		return telefonszam.substring(0,2) + "-" + telefonszam.substring(2,4) + "/" + telefonszam.substring(4,6) + "-" + telefonszam.substring(6,8) + "-" + telefonszam.substring(8);
	}
	
	public int getKorzet() {
		return Integer.valueOf(telefonszam.substring(2,4));
	}
	
	public String getSzolgaltato() {
		switch (getKorzet()) {
			case 20:
				return "Yettel";
			case 30:
				return "Telekom";
			case 70:
				return "Vodafone";
			default:
				return "Ismeretlen szolgáltató";
		}
	}

	public boolean telefonszamValid() {
		String minta = "^06[0-9]{9}$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(telefonszam);
		return matcher.find();
	}
	
	@Override
	public String toString() {
		return nev + " telefonszáma: " + masikFormatum();
	}

	@Override
	public int compareTo(Telefonszam o) {
		return nev.compareTo(o.nev);
	}
	
}
