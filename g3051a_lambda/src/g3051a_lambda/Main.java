package g3051a_lambda;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	public static void main(String args[]) { 
		//function
		Function<Integer,Double> fahrenheit = (x) -> 1.8*x+32;
		System.out.println(fahrenheit.apply(10));
		
		Function<String, Integer> ho = (x)-> Integer.valueOf(x.substring(5,7));
		System.out.println(ho.apply("2012.12.21."));
		
		BiFunction<Integer,Integer,Integer> d = (x,y) -> x*x-y*y;
		
		BiFunction<Integer,Integer,Double> pitagorasz = (a,b) -> Math.sqrt(a*a+b*b);
		System.out.println(pitagorasz.apply(5, 4));
		
		
		//predicate
		Predicate<Integer> p1 = (x)-> x>=5;
		Predicate<Integer> p2 = (x)-> x>=5 && x<=10;
		Predicate<String> p3 = (x)-> x.length()>=6;
		System.out.println(p1.test(14));
		System.out.println(p2.test(8));
		System.out.println(p3.test("alma"));
		System.out.println(p3.test("görögdinnye"));
		
		Predicate<Integer> p4 = (x)-> x>10;
		Predicate<Integer> p5 = (x)-> x%2==0;
		Predicate<Integer> p6 = (x)-> x%2==0 && x>10;
		
		System.out.println(p4.and(p5).test(18));
		System.out.println(p4.or(p5).test(17));
		System.out.println(p6.test(18));
		
		BiPredicate<Integer,Integer> p7 = (x,y)-> x>y;
		System.out.println(p7.test(18,16));
		System.out.println(p7.test(15,23));
		
		ArrayList<Integer> szamok = new ArrayList<Integer>();
		for(int i = 1; i < 5; i++)
			szamok.add(i);
		Function<Integer,Integer> negyzet = (x) -> x*x;
		Function<Integer,Integer> kob = (x) -> x*x*x;
		System.out.println(osszeg(szamok,negyzet));
		System.out.println(osszeg(szamok,kob));
		System.out.println(osszeg(szamok,(x)->x*x*x*x));
		
		//lista, számok 1-10ig, párosakat vagy páratlanokat összeadni
		ArrayList<Integer> szamok2 = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++)
			szamok.add(i);
		Predicate<Integer> paros = (x)-> x%2==0;
		Predicate<Integer> paratlan = (x)-> x%2==1;
		Predicate<Integer> nagyobb5 = (x)-> x>5;
		System.out.println(osszegParosParatlanhoz(szamok,paros.and(nagyobb5)));
		System.out.println(osszegParosParatlanhoz(szamok,paratlan));
		
		Diak diak = new Diak("Füty Imre",3.5);
		Function<Diak,Integer> osztondij = (x)-> (int)(x.atlag*1000) + 10000;
		System.out.println(osztondij.apply(diak));
		
		//consumer
		Consumer<String> c = x->System.out.println(x);
		Consumer<Integer> c_int = x->System.out.print(x + " ");
		Consumer<String> telefon = x->System.out.println(x.substring(0,3)+"-"+x.substring(3));
		Consumer<ArrayList<Integer>> feltolt = (x)-> {for(int i = 0; i < 10; i++) x.add(i);};
		Consumer<ArrayList<Integer>> listaPrint = (x)-> {for(int i : x) System.out.print(i + " ");};
		telefon.accept("310350");
		ArrayList<Integer> lista = new ArrayList<Integer>();
		feltolt.accept(lista);
		listaPrint.accept(lista);
		System.out.println();
		lista.forEach(c_int);
		System.out.println();
		
		Consumer<ArrayList<Integer>> kiirNegyzet = (x)-> {for(int i : x) System.out.print(negyzet.apply(i) + " ");};
		Consumer<ArrayList<Integer>> kiirKob = (x)-> {for(int i : x) System.out.print(kob.apply(i)+ " ");};
		kiirNegyzet.accept(lista);
		System.out.println();
		kiirKob.accept(lista);
	}
	
	public static int osszegParosParatlanhoz(ArrayList<Integer> szamok, Predicate<Integer> f) {
		int sum = 0;
		for(int i : szamok)
			if(f.test(i))
				sum += i;
		return sum;
	}
	
	public static int osszeg(ArrayList<Integer> szamok, Function<Integer,Integer> f) {
		int sum = 0;
		for(int i : szamok)
			sum += f.apply(i);
		return sum;
	}
}
