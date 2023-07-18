package g3051a_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader("maraton.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			ArrayList<Maraton> maratonok = new ArrayList<Maraton>();
			ArrayList<Maraton> maratonokFerfi = new ArrayList<Maraton>();
			ArrayList<Maraton> maratonokNo = new ArrayList<Maraton>();
			
			for(String s : bufferedReader.lines().toList()) {
				try {
					Maraton m = new Maraton(s);
					if(m.isValid()) {
						maratonok.add(m);
						if(m.getNem()=='F') maratonokFerfi.add(m);
						else if(m.getNem()=='N') maratonokNo.add(m);
					}
				}catch(MaratonException e) {
					System.out.println(e.getMessage());
				}
			}
			
			Collections.sort(maratonok,new MaratonRendezes());
			Collections.sort(maratonokFerfi,new MaratonRendezes());
			Collections.sort(maratonokNo,new MaratonRendezes());

			System.out.println("---ÖSSZES FUTÓ---");
			for(Maraton m : maratonok) 
				System.out.println(m + ", azaz " + m.hosszMPercben() + " másodperc");
			
			System.out.println("---FÉRFIAK---");
			for(Maraton m : maratonokFerfi) 
				System.out.println(m + ", azaz " + m.hosszMPercben() + " másodperc");
			
			System.out.println("---NŐK---");
			for(Maraton m : maratonokNo) 
				System.out.println(m + ", azaz " + m.hosszMPercben() + " másodperc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
