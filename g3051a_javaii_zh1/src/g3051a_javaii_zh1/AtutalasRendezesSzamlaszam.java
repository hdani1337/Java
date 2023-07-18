package g3051a_javaii_zh1;

import java.util.Comparator;

public class AtutalasRendezesSzamlaszam implements Comparator<Atutalas>{

	@Override
	public int compare(Atutalas o1, Atutalas o2) {
		return o1.getSzamlaszam().compareTo(o2.getSzamlaszam());
	}

}
