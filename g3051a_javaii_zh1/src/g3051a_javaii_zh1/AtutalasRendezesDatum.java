package g3051a_javaii_zh1;

import java.util.Comparator;

public class AtutalasRendezesDatum implements Comparator<Atutalas>{

	@Override
	public int compare(Atutalas o1, Atutalas o2) {
		return (o1.getDatum().compareTo(o2.getDatum()) == 0) ? o1.getNev().compareTo(o2.getNev()) : o1.getDatum().compareTo(o2.getDatum());
	}

}