package g3051a_exceptions;

public class Haromszog {
	private int a;
	private int b;
	private int c;
	
	public Haromszog(int a, int b, int c) throws HaromszogException {
		this.a = a;
		this.b = b;
		this.c = c;
		if(!isValid())
			throw new HaromszogException("A háromszög nem szerkeszthetõ");
	}

	public Haromszog() {
		this.a = this.b = this.c = 1;
	}
	
	public int kerulet() {
		return a+b+c;
	}
	
	public double terulet() {
		double s = kerulet()/2.0;
		double gyokAlatti = s*(s-a)*(s-b)*(s-c);
		return Math.sqrt(gyokAlatti);
	}
	
	public boolean isValid() {
		return (a>0 && b>0 && c>0) && (a+b>c && a+c>b && b+c>a);
	}
}
