package g3051a_elso;

import java.util.Comparator;

public class FiuSort implements Comparator<Par> {

	@Override
	public int compare(Par o1, Par o2) {
		return o1.getFiu().compareTo(o2.getFiu());
	}

}

