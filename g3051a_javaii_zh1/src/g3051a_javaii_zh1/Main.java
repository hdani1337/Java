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
			
			//rendezés számlaszám alapján
			System.out.println("-----Rendezés I.-----");
			Collections.sort(utalasok,new AtutalasRendezesSzamlaszam());
			for(Atutalas a : utalasok) 
				System.out.println(a + "\t(" + a.getSzamlaszam() + ")");
			
			//rendezés dátum alapján
			System.out.println("-----Rendezés II.-----");
			Collections.sort(utalasok,new AtutalasRendezesDatum());
			for(Atutalas a : utalasok) 
				System.out.println(a + "\t(" + a.getDatum() + ")");
			
			//csoportosítás bankok alapján
			System.out.println("-----Csoportosítás I.-----");
			HashMap<String, Integer> bankok = new HashMap<String, Integer>();
			for(Atutalas a : utalasok) {
				String aBank = a.getSzamlaszam().substring(0,3);
				if(bankok.containsKey(aBank)) {
					bankok.put(aBank, bankok.get(aBank) + a.getFizetes());
				}else bankok.put(aBank, a.getFizetes());
			}
			
			for(String bank : bankok.keySet())
				System.out.println(bank + "\t" + bankok.get(bank) + "Ft");
			
			
			//csoportosítás dátum alapján
			System.out.println("-----Csoportosítás II.-----");
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
			
			//bank bekérése
			System.out.println("-----Bank részesedése az átutalások között-----");
			String input = "";
			Scanner scanner = new Scanner(System.in);
			System.out.print("Kérem a bank azonosítóját: ");
			input = scanner.nextLine();
			
			int osszesFizu = 0;
			for(String bank : bankok.keySet())
				osszesFizu += bankok.get(bank);
			
			if(bankok.containsKey(input)) {
				double szazalek = (bankok.get(input) / (osszesFizu*1.0)) * 100;
				int kerek = (int) (szazalek * 100);
				System.out.print((kerek / 100.0) + "%" + "\t(" + bankok.get(input) + "Ft / " + osszesFizu + "Ft)");
			}else {
				System.out.println("Ilyen bank nem található az átutalások között!");
			}
			
			bufferedReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
