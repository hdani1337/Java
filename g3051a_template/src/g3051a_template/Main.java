package g3051a_template;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		LinkedList<Integer> szamok = new LinkedList<Integer>(10);
		for(int i = 1; i < 10; i++)
			szamok.addItem(i);
		
		LinkedList<Integer> szamok2 = new LinkedList<Integer>(10);
		for(int i = 1; i < 10; i++)
			szamok2.addItemBefore(i);
		System.out.println(szamok);
		System.out.println(szamok2);
		
		System.out.print("Kérek egy számot: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(szamok.get(input));
		scan.close();
	}

}
