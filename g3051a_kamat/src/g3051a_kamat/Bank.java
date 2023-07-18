package g3051a_kamat;

public class Bank {
	public static int hozam(int alap, int kamat, int ido) {	
		double vegosszeg = alap * Math.pow(((100+kamat)/100.0),ido);
		return kerekit((int) Math.round(vegosszeg));
	}
	
	public static int kerekit(int szam) {
		int kerek = szam;
		if(kerek%10 <= 2)
			kerek -= kerek%10;
		else if(kerek%10 >= 3 && kerek%10 <= 7) {	
			kerek -= kerek%10;
			kerek += 5;
		}else if(kerek%10 >= 8) {	
			kerek -= kerek%10;
			kerek += 10;
		}
		return kerek;
	}
}
