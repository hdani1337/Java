package g3051a_elso;

import java.util.Comparator;

public class LanySort implements Comparator<Par> {

	@Override
	public int compare(Par o1, Par o2) {
		return o1.getLany().compareTo(o2.getLany());
	}

}
