package eleventh_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void print(List<Lakas> lakasok)
	{
		for(int i=0;i<lakasok.size();i++)
		{
			System.out.println(lakasok.get(i));
		}
	}
	public static void main(String[] args) {
		ArrayList<Lakas> adatok = new ArrayList<Lakas>();
		try
		{
			FileReader file = new FileReader("11.txt");
			BufferedReader input = new BufferedReader(file);
			String line = null;
			int sor=0;
			while((line=input.readLine())!=null)
			{
				if(sor!=0)
				{
					Lakas lakas = new Lakas(line);
					//System.out.println(lakas);
					adatok.add(lakas);
				}
				sor++;
			}
			Predicate<Lakas> p1 =x->x.getKerulet()==1;
			Predicate<Lakas> p2 =x->x.getNem().equals("N");
			Predicate<Lakas> p3 =p1.and(p2);
			
			Function<Lakas, Double> ar = x-> (1.0*(x.getAr())/x.getTerulet());
			//adatok.stream().filter(x->x.getKerulet()==1).collect(Collectors.toList());
			List<Lakas> eredmeny = adatok.stream().filter(p3).collect(Collectors.toList());
			for(int i=0;i<eredmeny.size();i++)
			{
				//System.out.println(eredmeny.get(i));
			}
			
			System.out.println(adatok.stream().map(ar).collect(Collectors.toList()));
			List<String> nevek=adatok.stream().filter(p3).map(x->x.getTulajdonos()).sorted().collect(Collectors.toList());
			for(int i=0;i<nevek.size();i++)
			{
				System.out.println(nevek.get(i));
			}
			
			eredmeny =adatok.stream().filter(p1).sorted(Comparator.comparing(Lakas::getAr)).limit(4).collect(Collectors.toList());
			print(eredmeny);
			
			long db =adatok.stream().filter(x->x.getKerulet()==5).mapToInt(x->x.getTerulet()).count();
			System.out.println("V.kerületi lakások száma: "+db);
			
			OptionalDouble db1 =adatok.stream().filter(x->x.getKerulet()==5).mapToInt(x->x.getTerulet()).average();
			if (db1.isPresent()==true)
			{
				System.out.println("V.kerületi lakások száma: "+db1.getAsDouble());
			}
			else
			{
				System.out.println("Nem volt Lakas");
			}
			
			
			
			OptionalInt max =adatok.stream().filter(x->x.getKerulet()==1).mapToInt(x->x.getTerulet()).max();
			if (max.isPresent()==true)
			{
				System.out.println("I. kerületi legnagyobb lakás: "+max.getAsInt());
			}
			else
			{
				System.out.println("Nem volt Lakas");
			}
			
			
			input.close();
		}
		catch(Exception exc)
		{
			System.out.println(exc);
		}
	}
}