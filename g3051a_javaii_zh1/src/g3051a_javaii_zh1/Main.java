package g3051a_javaii_zh1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("atutalas.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<Atutalas> utalasok = new ArrayList<Atutalas>();
			
			for(String s : bufferedReader.lines().toList()) {
				Atutalas a = new Atutalas(s);
				if(a.isValid())
					utalasok.add(a);
			}
			
			//rendez�s sz�mlasz�m alapj�n
			System.out.println("-----Rendez�s I.-----");
			Collections.sort(utalasok,new AtutalasRendezesSzamlaszam());
			for(Atutalas a : utalasok) 
				System.out.println(a + "\t(" + a.getSzamlaszam() + ")");
			
			//rendez�s d�tum alapj�n
			System.out.println("-----Rendez�s II.-----");
			Collections.sort(utalasok,new AtutalasRendezesDatum());
			for(Atutalas a : utalasok) 
				System.out.println(a + "\t(" + a.getDatum() + ")");
			
			//csoportos�t�s bankok alapj�n
			System.out.println("-----Csoportos�t�s I.-----");
			HashMap<String, Integer> bankok = new HashMap<String, Integer>();
			for(Atutalas a : utalasok) {
				String aBank = a.getSzamlaszam().substring(0,3);
				if(bankok.containsKey(aBank)) {
					bankok.put(aBank, bankok.get(aBank) + a.getFizetes());
				}else bankok.put(aBank, a.getFizetes());
			}
			
			for(String bank : bankok.keySet())
				System.out.println(bank + "\t" + bankok.get(bank) + "Ft");
			
			
			//csoportos�t�s d�tum alapj�n
			System.out.println("-----Csoportos�t�s II.-----");
			HashMap<String, Integer> datumok = new HashMap<String, Integer>();
			for(Atutalas a : utalasok) {
				String aDatum = a.getDatum();
				if(datumok.containsKey(aDatum)) {
					datumok.put(aDatum, datumok.get(aDatum) + a.getFizetes());
				}else datumok.put(aDatum, a.getFizetes());
			}
			Object rendezettDatumok[] = datumok.keySet().toArray();
			Arrays.sort(rendezettDatumok);
			
			for(Object datum : rendezettDatumok)
				System.out.println(datum + "\t" + datumok.get(datum) + " Ft");
			
			//bank bek�r�se
			System.out.println("-----Bank r�szesed�se az �tutal�sok k�z�tt-----");
			String input = "";
			Scanner scanner = new Scanner(System.in);
			System.out.print("K�rem a bank azonos�t�j�t: ");
			input = scanner.nextLine();
			
			int osszesFizu = 0;
			for(String bank : bankok.keySet())
				osszesFizu += bankok.get(bank);
			
			if(bankok.containsKey(input)) {
				double szazalek = (bankok.get(input) / (osszesFizu*1.0)) * 100;
				int kerek = (int) (szazalek * 100);
				System.out.print((kerek / 100.0) + "%" + "\t(" + bankok.get(input) + "Ft / " + osszesFizu + "Ft)");
			}else {
				System.out.println("Ilyen bank nem tal�lhat� az �tutal�sok k�z�tt!");
			}
			
			bufferedReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
