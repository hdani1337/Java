package g3051a_regex2;

import java.util.Comparator;

public class TanfolyamRendezes implements Comparator<Tanfolyam>{

	@Override
	public int compare(Tanfolyam o1, Tanfolyam o2) {
		return (o1.hosszPercben() - o2.hosszPercben() == 0) ? o1.getNev().compareTo(o2.getNev()) : o1.hosszPercben() - o2.hosszPercben();
	}

}
