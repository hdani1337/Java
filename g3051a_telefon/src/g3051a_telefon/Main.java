package g3051a_telefon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		try {
			FileReader fileReader = new FileReader("telefon.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<Telefon> telefonok = new ArrayList<Telefon>();
			
			for(String s : bufferedReader.lines().toList()) {
				Telefon t = new Telefon(s);
				if(t.isValid())
					telefonok.add(t);
			}
			
			Collections.sort(telefonok,new TelefonRendezes());
			
			for(Telefon t : telefonok) 
				System.out.println(t +  " " + t.getVege());
			
			System.out.println("Yettel (20): " + telefonszamSzolgaltatokSzerint(20,telefonok) + " hívás");
			System.out.println("Telekom (30): " + telefonszamSzolgaltatokSzerint(30,telefonok) + " hívás");
			System.out.println("Vodafone (70): " + telefonszamSzolgaltatokSzerint(70,telefonok) + " hívás");
			
			try {
		        FileWriter out = new FileWriter("telefonokKi.txt");
		        BufferedWriter output = new BufferedWriter(out);
		        for (Telefon t : telefonok)
		        	output.append(t + " A hívás " + t.getVege() + "-kor fejezõdött be.\n");		   
		        output.close();     	
	        } catch (IOException e) {
	        	
	        }
			
			bufferedReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int telefonszamSzolgaltatokSzerint(int szolgaltatoKod, ArrayList<Telefon> telefonok) {
		int mennyi = 0;
		for(Telefon t : telefonok) {
			String minta = "06" + szolgaltatoKod + "[0-9]{7}";
			Pattern pattern = Pattern.compile(minta);
			Matcher matcher = pattern.matcher(t.getTelefonszam());
			if(matcher.find()) mennyi++;
		}
		return mennyi;
	}

}
