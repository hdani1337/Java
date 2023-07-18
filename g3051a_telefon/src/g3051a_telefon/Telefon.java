package g3051a_telefon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefon {

	  	private String telefonszam;
	    private String kezdes;
	    private String idotartam;

	    public Telefon(String telefonszam, String kezdes, String idotartam) {
	        this.telefonszam = telefonszam;
	        this.kezdes = kezdes;
	        this.idotartam = idotartam;
	    }
	    
	    public Telefon(String line) {
	    	String data[] = line.split("\s");
	        this.telefonszam = data[0];
	        this.kezdes = data[1];
	        this.idotartam = data[2];
	    }

	    public Telefon(Telefon masik){
	        this.telefonszam = masik.telefonszam;
	        this.kezdes = masik.kezdes;
	        this.idotartam = masik.idotartam;
	    }

		public String getTelefonszam() {
			return telefonszam;
		}

		public void setTelefonszam(String telefonszam) {
			this.telefonszam = telefonszam;
		}

		public String getKezdes() {
			return kezdes;
		}

		public void setKezdes(String kezdes) {
			this.kezdes = kezdes;
		}

		public String getIdotartam() {
			return idotartam;
		}

		public void setIdotartam(String vege) {
			this.idotartam = vege;
		}
		
		public int hosszPercben(String time) {
			int vegeOra = Integer.parseInt(time.substring(0,2));
			int vegePerc = Integer.parseInt(time.substring(3,5));
			
			return (vegeOra*60+vegePerc);
		}
		
		public String getVege() {
			int vegePerc = hosszPercben(kezdes) + hosszPercben(idotartam)/60;
			String ora = vegePerc/60+"";
			String perc = vegePerc%60+"";
			return ora + ":" + ((perc.length() < 2) ? "0" : "") + perc;
		}
		
		public boolean timeValid(String time) {
			String minta = "^[0-9]{2}:[0-9]{2}$";
			Pattern pattern = Pattern.compile(minta);
			Matcher matcher = pattern.matcher(time);
			if(!matcher.find()) return matcher.find();
			
			int ora = Integer.parseInt(time.substring(0,2));
			int perc = Integer.parseInt(time.substring(3,5));
			return (ora>= 0 && ora<=23) && (perc>=0 && perc<=59);
		}
		
		public boolean numberValid(String number) {
			String minta = "^06[0-9]{9}$";
			Pattern pattern = Pattern.compile(minta);
			Matcher matcher = pattern.matcher(number);
			return matcher.find();
		}
		
		public boolean isValid() {
			return this.timeValid(kezdes) && this.timeValid(idotartam) && this.numberValid(telefonszam);
		}

		@Override
		public String toString() {
			return telefonszam + " számról " + kezdes + "-kor történt egy " + hosszPercben(idotartam) + " másodperces hívás.";
		}
		
		
}
