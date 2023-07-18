package g3051a_verem;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Verem<Integer> verem = new Verem<Integer>();
		
		/*Random rand = new Random();
		
		for(int i = 1; i < 10; i++) {
			int x = Math.abs(rand.nextInt()) % 20;
			verem.push(x);
		}
		
		System.out.println(verem);
		
		System.out.println(verem.search(4));*/
		
		String lengyel = "30 50 - 10 20 + * * *";
		String adatok[] = lengyel.split("\\s");
		for(String s : adatok) {
			try {
				if(s.equals("+")) 
					verem.push(verem.pop()+verem.pop());
				else if(s.equals("-"))
					verem.push(verem.pop()-verem.pop());
				else if(s.equals("*"))
					verem.push(verem.pop()*verem.pop());
				else if(s.equals("/"))
					verem.push(verem.pop()/verem.pop());
				else if(s.equals("%"))
					verem.push(verem.pop()%verem.pop());
				else verem.push(Integer.valueOf(s));
			}catch (UresVeremException e) {
				e.printStackTrace();
			}finally {
				System.out.println(verem);
			}
		}
	}
}
