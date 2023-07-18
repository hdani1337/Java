package g3051a_exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaratonUtilities {
	public static boolean timeValid(String time) {
		String minta = "^[0-9]{2}:[0-9]{2}:[0-9]{2}$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(time);
		if(!matcher.find()) return matcher.find();
		
		int ora = Integer.parseInt(time.substring(0,2));
		int perc = Integer.parseInt(time.substring(3,5));
		int mp = Integer.parseInt(time.substring(6,8));
		return (ora>= 0 && ora<=23) && (perc>=0 && perc<=59) && (mp>=0 && mp<=59);
	}

	public static boolean nameValid(String nev) {
		String minta = "^[A-Z,ÖÜÓŐÚÉÁŰÍ][a-z,öüóőúéáűí]+\\s[A-Z,ÖÜÓŐÚÉÁŰÍ][a-z,öüóőúéáűí]+$";
		Pattern pattern = Pattern.compile(minta);
		Matcher matcher = pattern.matcher(nev);
		return matcher.find();
	}
}
