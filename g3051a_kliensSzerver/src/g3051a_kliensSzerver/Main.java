package g3051a_kliensSzerver;

public class Main {
	public class OtherThread implements Runnable {		
		@Override
		public void run() {
			while(true) {
				
			}
		}
	}


	public static void main(String[] args) {
		Cesar.init();
		String txt = "Megszentsegtelenithetetlensegeskedeseitekert";
		for(int i = 0; i < Cesar.sorok.size(); i++) {
			String codedTXT = Cesar.code(txt, i);
			System.out.println("Eltol�s: " + i + ", k�dolt sz�veg: " + codedTXT + " ----- Dek�dolt sz�veg: " + Cesar.decode(codedTXT, i));
		}
	}

}
