package g3051a_exceptions;

import java.util.Comparator;

public class MaratonRendezes implements Comparator<Maraton> {

	@Override
	public int compare(Maraton o1, Maraton o2) {
		return (o1.hosszMPercben() - o2.hosszMPercben() == 0) ? o1.getNev().compareTo(o2.getNev()) : o1.hosszMPercben() - o2.hosszMPercben();
	}


}
