package g3051a_telefon;

import java.util.Comparator;

public class TelefonRendezes implements Comparator<Telefon>{

	@Override
	public int compare(Telefon o1, Telefon o2) {
		return (o1.hosszPercben(o1.getIdotartam()) - o2.hosszPercben(o2.getIdotartam()) == 0) ? 
				o1.hosszPercben(o1.getKezdes()) - o2.hosszPercben(o2.getKezdes()) 
				: o1.hosszPercben(o1.getIdotartam()) - o2.hosszPercben(o2.getIdotartam());
	}

}
