package g3051a_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Min {

	public static void main(String[] args) {
		rendszam();
	}
	
	public static boolean leapYear(int year) {
		return year % 4 == 0;
	}
	
	public static boolean valid_date(String date) {
		int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int ev = Integer.parseInt(date.substring(0,4));
		int honap = Integer.parseInt(date.substring(5,7));
		int nap = Integer.parseInt(date.substring(8,10));
		if(leapYear(ev)) days[2] = 29;
		
		return (nap <= days[honap]);
	}
	
	public static boolean valid(String date) {
		String minta = "(19|20)[0-9]{2}[.]((0[1-9])|(1[1-2]))[.]((0[1-9])|([12][0-9])|(3[0-1])[.])";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(date);
		return matcher.find() && valid_date(date);
	}
	
	
	public static void datum() {
		String kod = "2023.02.30.";
		String minta = "(19|20)[0-9]{2}[.]((0[1-9])|(1[1-2]))[.]((0[1-9])|([12][0-9])|(3[0-1])[.])";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(kod);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = kod.substring(x,y);
			System.out.println(txt);
		}
	}
	
	public static void rendszam() {
		String kod = "ABC-123 vagy AA-AA-143 TC-42-78";
		String minta = "([A-Z]{3}-[0-9]{3})|([A-Z]{2}-[A-Z]{2}-[0-9]{3})|([A-Z]{2}-[0-9]{2}-[0-9]{2})";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(kod);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = kod.substring(x,y);
			System.out.println(txt);
		}
	}
	
	public static void neptunkod() {
		String kod = "+G3051A és 75AA98 vagy AA12L$";
		String minta = "[A-Za-z0-9]{6}";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(kod);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = kod.substring(x,y);
			System.out.println(txt);
		}
	}
	
	public static void mobilszam() {
		String szam = "+36-23-310-4115 vagy +36-20-340-4215";
		String minta = "[+][1-9][0-9]-[237]0-[0-9]{3}-[0-9]{4}";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(szam);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = szam.substring(x,y);
			System.out.println(txt);
		}
	}
	
	public static void telefonszam() {
		String szam = "06-93-310-415 vagy 06-93-340-415";
		String minta = "06-[1-9][0-9]-[0-9]{3}-[0-9]{3}";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(szam);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = szam.substring(x,y);
			System.out.println(txt);
		}
	}
	
	public static void iranyitoszam() {
		String kanizsa = "8800 3447 és 1848";
		String minta = "[1-9][0-9]{3}";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(kanizsa);
		/*if(matcher.find()) System.out.println("OK");
		else System.out.println("Nem OK");
		*/
		while(matcher.find()) {
			int x = matcher.start();
			int y = matcher.end();
			System.out.println(x + ":" + y);
			String txt = kanizsa.substring(x,y);
			System.out.println(txt);
		}
	}

}
