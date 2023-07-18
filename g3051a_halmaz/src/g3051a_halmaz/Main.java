package g3051a_halmaz;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> teszt3as = new Set<Integer>();
		for(int i = 60; i >= 0; i-=3) {
			teszt3as.addItem(i);
			System.out.println(teszt3as);
		}
		
		Set<Integer> teszt2es = new Set<Integer>();
		for(int i = 0; i <= 60; i+=2){
			teszt2es.addItem(i);
			System.out.println(teszt2es);
		}
		
		System.out.println("Random sz�mok:\t");
		
		Set<Integer> tesztRandom = new Set<Integer>();
		for(int i = 0; i <= 60; i+=2)
			tesztRandom.addItem((new Random()).nextInt(0,100));
		
		
		System.out.println("3-al oszthat� sz�mok:\t\t\t" + teszt3as);
		System.out.println("2-vel oszthat� sz�mok:\t\t\t" + teszt2es);
		
		System.out.println("2-vel �s 3-al oszthat� sz�mok:\t\t" + teszt2es.intersection(teszt3as));
		System.out.println("2-vel vagy 3-al oszthat� sz�mok:\t" + teszt2es.union(teszt3as));
		
		System.out.println("Random sz�mok:\t" + tesztRandom);
	}

}
