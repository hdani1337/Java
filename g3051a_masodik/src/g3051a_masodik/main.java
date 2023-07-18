package g3051a_masodik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fileReader;
		try {
			fileReader = new FileReader("kiraly.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			ArrayList<Kiraly> kiralyok = new ArrayList<Kiraly>();
			while((line = bufferedReader.readLine()) != null) 
				kiralyok.add(new Kiraly(line));
			bufferedReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
