package g3051a_javaii_zh1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atutalas {
	private String nev;
	private String szamlaszam;
	private int fizetes;
	private String datum;
	
	
	
	public Atutalas(String sor) {
		String data[] = sor.split(",");
		try {
			if(nameValid(data[0]))
				this.nev = data[0];
			else throw new BankException("Hibás név: " + data[0]);
		}catch(BankException b) {
			System.out.println(b.getMessage());
			this.nev = "invalid";
		}
		
		try {
			if(bankValid(data[1]))
				this.szamlaszam = data[1];
			else throw new BankException("Hibás azonosító: " + data[1]);
		}catch(BankException b) {
			System.out.println(b.getMessage());
			this.szamlaszam = "invalid";
		}
		this.fizetes = Integer.valueOf(data[2]);
		this.datum = data[3];
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getSzamlaszam() {
		return szamlaszam;
	}
	public void setSzamlaszam(String szamlaszam) {
		this.szamlaszam = szamlaszam;
	}
	public int getFizetes() {
		return fizetes;
	}
	public void setFizetes(int fizetes) {
		this.fizetes = fizetes;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	@Override
	public String toString() {
		return nev + "\t" + szamlaszam.substring(0,3) + "\t" + fizetes + " Ft";
	}
	
	public static boolean nameValid(String nev) {
		String minta = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(nev);
		return matcher.find();
	}
	
	public static boolean bankValid(String nev) {
		String minta = "^([A-Z]|&){3}-[0-9]{4}$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(nev);
		return matcher.find();
	}
	
	public boolean isValid() {
		return this.bankValid(szamlaszam) && this.nameValid(nev);
	}
}
