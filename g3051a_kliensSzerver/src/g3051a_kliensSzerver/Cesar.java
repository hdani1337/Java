package g3051a_kliensSzerver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cesar {
	public static ArrayList<String> sorok;
	
	public static void init() {
		try {
			sorok = new ArrayList<String>();
			FileReader fileReader = new FileReader("cesar.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			for(String s : bufferedReader.lines().toList()) 
				sorok.add(s);
			bufferedReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String code(String input, int eltolas) {
		String output = "";
		if(sorok == null) init();
		for(int i = 0; i < input.length(); i++) {
			int origPos = sorok.get(0).indexOf(input.toUpperCase().charAt(i));
			output = output + sorok.get(eltolas).charAt(origPos);
		}
		return output;
	}
	
	public static String decode(String input, int eltolas){
		String output = "";
		if(sorok == null) init();
		for(int i = 0; i < input.length(); i++) {
			int origPos = sorok.get(eltolas).indexOf(input.charAt(i));
			output = output + sorok.get(0).charAt(origPos);
		}
		return output;
	}
}
