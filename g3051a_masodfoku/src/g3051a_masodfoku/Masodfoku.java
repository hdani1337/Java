package g3051a_masodfoku;

public class Masodfoku {
	public static int diszkriminans(int ax, int bx, int c) {
		return bx*bx - 4*ax*c;
	}
	
	public static int megoldasokSzama(int ax, int bx, int c) {
		if(diszkriminans(ax,bx,c) > 0) return 2;
		if(diszkriminans(ax,bx,c) == 0) return 1;
		return 0;
	}
	
	public static double x1(int ax, int bx, int c) {
		return (-bx + Math.sqrt(diszkriminans(ax,bx,c)))/(2*ax);
	}
	
	public static double x2(int ax, int bx, int c) {
		return (-bx - Math.sqrt(diszkriminans(ax,bx,c)))/(2*ax);
	}
}
