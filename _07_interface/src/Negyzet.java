public class Negyzet implements Alakzat, Printable{
    private int a;

    public Negyzet() {
        this.a = 5;
    }

    public Negyzet(Negyzet masik) {
        this.a = masik.a;
    }

    public Negyzet(int a) {
        this.a = a;
    }

    @Override
    public double kerulet() {
        return 4*a;
    }

    @Override
    public double terulet() {
        return a*a;
    }

    @Override
    public void print() {

    }
}
