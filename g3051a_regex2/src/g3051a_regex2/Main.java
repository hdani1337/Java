package g3051a_regex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("tanfolyam.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			ArrayList<Tanfolyam> tanfolyamok = new ArrayList<Tanfolyam>();
			
			for(String s : bufferedReader.lines().toList()) {
				Tanfolyam t = new Tanfolyam(s);
				if(t.isValid())
					tanfolyamok.add(t);
			}
			
			Collections.sort(tanfolyamok,new TanfolyamRendezes());
			
			for(Tanfolyam t : tanfolyamok) 
				System.out.println(t + " " + t.hosszPercben() + " perc");
			
			bufferedReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean timeValid(String time) {
		String minta = "^[0-9]{2}:[0-9]{2}$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(time);
		return matcher.find();
	}

	public static boolean nameValid(String nev) {
		String minta = "^((dr.|Dr.)\\s)?[A-Z][a-z]+(\\s[A-Z][a-z]+){1,2}$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(nev);
		return matcher.find();
	}
}
