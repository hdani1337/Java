package g3051a_elso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("latin.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			ArrayList<Par> parok = new ArrayList<Par>();
			while((line = bufferedReader.readLine()) != null) 
				parok.add(new Par(line));
			bufferedReader.close();
			
			System.out.println("-----Párok Lányok szerint-----");
			Collections.sort(parok, new LanySort());
			for(Par p : parok)
				System.out.println(p);
			
			System.out.println("-----Párok Fiúk szerint-----");
			Collections.sort(parok, new FiuSort());
			for(Par p : parok)
				System.out.println(p);
			
			System.out.println("-----Párok Tánc szerint-----");
			Collections.sort(parok);
			for(Par p : parok)
				System.out.println(p);
			
			HashMap<String, Integer> tancok = new HashMap<String, Integer>();
			for(Par p : parok) {
				if(tancok.containsKey(p.getTanc())) 
					tancok.put(p.getTanc(), tancok.get(p.getTanc())+1);
				else tancok.put(p.getTanc(), 1);
			}
			
			System.out.println("-----Táncok száma-----");
			String tempTanc = null;
			int tempTancDb = 0;
			for(String s : tancok.keySet()) {
				System.out.println(s + ": " + tancok.get(s) + " előadás");
				if(tancok.get(s) > tempTancDb) {
					tempTanc = s;
					tempTancDb = tancok.get(s);
				}
			}
			System.out.println("Legnépszerűbb tánc a " + tempTanc + ", " + tempTancDb + " előadással.");
			
			HashMap<String, ArrayList<Par>> tancokParok = new HashMap<String, ArrayList<Par>>();
			for(Par p : parok) {
				if(tancokParok.containsKey(p.getTanc()))
					tancokParok.get(p.getTanc()).add(p);
				else {
					ArrayList<Par> l = new ArrayList<Par>();
					l.add(p);
					tancokParok.put(p.getTanc(), l);
				}
			}
			
			for(String s : tancokParok.keySet()) {
				System.out.println("-----" + s + "-----");
				FileWriter fileWriter = new FileWriter(s.toLowerCase()+".txt");
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(s + "\n");
				for(Par p : tancokParok.get(s))  {
					System.out.println(p.getLany() + " és " + p.getFiu());
					bufferedWriter.append(p.getLany() + " és " + p.getFiu() + "\n");
				}
				bufferedWriter.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
